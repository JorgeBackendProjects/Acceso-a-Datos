package MongoDB;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import Entidades.Pago;

public class MongoDB {
	
    public static void main(String[] args) {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        // Replace the uri string with your MongoDB deployment's connection string
        
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/")) {
        	
            MongoDatabase database = mongoClient.getDatabase("reservas").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<PagoMongo> collection = database.getCollection("Pagos", PagoMongo.class);
            PagoMongo pago = collection.find(eq("pago")).first();
            System.out.println(pago.toString());
        }
    }
}
