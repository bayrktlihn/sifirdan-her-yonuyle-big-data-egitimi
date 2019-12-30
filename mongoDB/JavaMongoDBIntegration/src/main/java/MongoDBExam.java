import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class MongoDBExam {
	public static void main(String[] args) {
		MongoClient mc = new MongoClient("localhost",27017);
		DB database = mc.getDB("test");
		DBCollection collection = database.getCollection("user");
		
		
//		Document Ekleme
//		BasicDBObject obj = new BasicDBObject()
//				.append("name", "deniz bayraktar")
//				.append("date", "2000")
//				.append("country", "Turkey")
//				.append("test","test")
//				;
//		
//		BasicDBObject obj2 = new BasicDBObject()
//				.append("name", "halil ibrahim göker")
//				.append("date", "1990")
//				.append("country", "Turkey");
//		
//		WriteResult wr = collection.insert(obj);
//		WriteResult wr2 = collection.insert(obj2);
//		
//		System.out.println(wr);
//		System.out.println(wr2);
		
		
//		Document Listeleme
//		DBCursor cursor = collection.find();
//		
//		DBCursor cursor2 = collection.find(new BasicDBObject("name", "alihan bayraktar"));
//		
//		System.out.println("Bütün documentleri getirir");
//		while(cursor.hasNext()) {
//			DBObject obj = cursor.next();
//			System.out.println(obj);
//		}
//		System.out.println("\nSadece name mi alihan bayraktar olan documenti getirir.");
//		while(cursor2.hasNext()) {
//			System.out.println(cursor2.next());
//		}
		
//		BasicDBObject obj2 = new BasicDBObject()
//		.append("name", "halil ibrahim göker güncel")
//		.append("date", "1990")
//		.append("country", "Turkey");
		
//		Documentlerden datesi 1990 olanlari günceller
//		collection.update(new BasicDBObject("date", "1990"), new BasicDBObject("$set",obj2));
		
//		Collectionun tamamini silme
//		collection.drop();
		
//		databasei siler
		database.dropDatabase();
		
		
	}
}
