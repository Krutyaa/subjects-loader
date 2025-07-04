package _VP2.KedelidzeKrutyakov.subjects_loader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SubjectsLoaderApplication {


	public static void main(String[] args) {
		SpringApplication.run(SubjectsLoaderApplication.class, args);
	}

	@Scheduled(cron = "${job.cron-expression}")
	void some() throws InterruptedException {
		System.out.println("Checking if update is needed...");
	}

}
