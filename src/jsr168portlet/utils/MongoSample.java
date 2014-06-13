package jsr168portlet.utils;

import java.net.*;
import java.util.*;

import org.bson.types.*;
import org.mongodb.morphia.*;
import org.mongodb.morphia.annotations.*;
import org.mongodb.morphia.query.*;

import com.mongodb.*;

public class MongoSample {

	static class Consts {
		static final String DatabaseHost = null;
		static final int DatabasePort = 0;
		static final String DatabaseName = null;
	}

	static MongoClient mongo;
	static Datastore ds;
	static Morphia morphia;

	public static void main(String[] args) {
		try {
			mongo = new MongoClient(Consts.DatabaseHost, Consts.DatabasePort);
			morphia = new Morphia();
			morphia.map(Employee.class);
			ds = morphia.createDatastore(mongo, Consts.DatabaseName);

			ds.save(new Employee("Mister", "GOD", null, 0));

			// get an employee without a manager
			Employee boss = ds.find(Employee.class).field("manager")
					.equal(null).get();

			Key<Employee> scottsKey = ds.save(new Employee("Scott",
					"Hernandez", ds.getKey(boss), 150 * 1000));

			// add Scott as an employee of his manager
			UpdateResults res = ds.update(
					boss,
					ds.createUpdateOperations(Employee.class).add("underlings",
							scottsKey));

			// get Scott's boss; the same as the one above.
			Employee scottsBoss = ds.find(Employee.class)
					.filter("underlings", scottsKey).get();

			for (Employee e : ds.find(Employee.class, "manager", boss))
				System.out.println(e);

		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}

	}

}

class Address {

}

@Entity("employees")
class Employee {
	public Employee(String firstName, String lastName, Object object, int i) {
		this.firstName = firstName;
		this.lastName = lastName;
		manager = new Key<Employee>(Employee.class, object);
	}

	// auto-generated, if not set (see ObjectId)
	@Id
	ObjectId id;

	// value types are automatically persisted
	String firstName, lastName;

	// only non-null values are stored
	Long salary = null;

	// by default fields are @Embedded
	Address address;

	// references can be saved without automatic loading
	Key<Employee> manager;

	// refs are stored**, and loaded automatically
	@Reference
	List<Employee> underlings = new ArrayList<Employee>();

	// stored in one binary field
	// @Serialized EncryptedReviews;

	// fields can be renamed
	@Property("started")
	Date startDate;
	@Property("left")
	Date endDate;

	// fields can be indexed for better performance
	@Indexed
	boolean active = false;

	// fields can loaded, but not saved
	@NotSaved
	String readButNotStored;

	// fields can be ignored (no load/save)
	@Transient
	int notStored;

	// not @Transient, will be ignored by Serialization/GWT for example.
	transient boolean stored = true;
}
