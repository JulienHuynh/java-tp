package fr.hetic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FileSystemDatabaseFileReader {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Reader calculateurFicherDb = (Reader) context.getBean("calculateurFicherDb");
        Reader calculateurFicher = (Reader) context.getBean("calculateurFicher");
        DataSourceEnum source = DataSourceEnum.valueOf(args[0].toUpperCase());

        switch (source) {
            case DATABASE:
                calculateurFicherDb.read(args[1]);
                break;
            case FILESYSTEM:
                calculateurFicher.read(args[1]);
                break;
            default:
                System.out.println("Source de données invalide.");
        }
    }
}
