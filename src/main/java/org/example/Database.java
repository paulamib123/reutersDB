//package org.example;
//
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;
//
//public class Database {
//
//    public static void connectToDatabase {
//        // MongoDB connection URI
//        String uri = "mongodb+srv://akshat64647:UZBFqEXaxP4yynr@cluster0.gtuqhal.mongodb.net/News/?retryWrites=true&w=majority";
//
//        // Create a MongoClientURI with the connection string
//        MongoClientURI connectionString = new MongoClientURI(uri);
//
//        // Create a MongoClient using the connection URI
//        MongoClient mongoClient = new MongoClient(connectionString);
//
//        // Get the database
//        MongoDatabase database = mongoClient.getDatabase(connectionString.getDatabase());
//
//        // Get the collection
//        MongoCollection<Document> collection = database.getCollection("Reut2009");
//
////        // Create a document to insert
////        Document document = new Document("name", "John")
////                .append("age", 30)
////                .append("city", "New York");
////
////        // Insert the document into the collection
////        collection.insertOne(document);
//
//        // Close the MongoDB client
//        mongoClient.close();
//    }
//}
