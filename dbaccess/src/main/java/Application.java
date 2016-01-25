import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.OMDSRepository;

/**
 * Created by thieste on 17.01.16.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private OMDSRepository omdsRepository;

//    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        omdsRepository.count();
    }
}
