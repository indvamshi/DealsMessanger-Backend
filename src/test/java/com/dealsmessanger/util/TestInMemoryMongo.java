package com.dealsmessanger.util;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.dealsmessanger.model.Business;
import com.mongodb.Mongo;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.RuntimeConfig;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.extract.UserTempNaming;

public class TestInMemoryMongo {

	private static final String LOCALHOST = "127.0.0.1";
    private static final String DB_NAME = "itest";
    private static final int MONGO_TEST_PORT = 27028;
    
    private static MongodProcess mongoProcess;
    private static Mongo mongo;
    
    private MongoTemplate template;
    

    @BeforeClass
    public static void initializeDB() throws IOException {

        RuntimeConfig config = new RuntimeConfig();
        config.setExecutableNaming(new UserTempNaming());

        MongodStarter starter = MongodStarter.getInstance(config);

        MongodExecutable mongoExecutable = starter.prepare(new MongodConfig(Version.V2_2_0, MONGO_TEST_PORT, false));
        mongoProcess = mongoExecutable.start();

        mongo = new Mongo(LOCALHOST, MONGO_TEST_PORT);
        mongo.getDB(DB_NAME);
    }

    @AfterClass
    public static void shutdownDB() throws InterruptedException {
        mongo.close();
        mongoProcess.stop();
    }

    
    public MongoTemplate getTemplate() {
    	return new MongoTemplate(mongo, DB_NAME);
    }
//    @Before
//    public void setUp() throws Exception {
//        template = new MongoTemplate(mongo, DB_NAME);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        template.dropCollection(Business.class);
//    }

//	@Test
//	public void testBean() {
//		
//		Business business = new Business();
//		template.save(business);
//		
//		Assert.assertNotNull(template.findAll(Business.class));
//	}
}
