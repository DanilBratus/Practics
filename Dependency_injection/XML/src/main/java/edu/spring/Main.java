package edu.spring;

import edu.spring.domain.Person;
import edu.spring.service.PersonService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PersonService personService = context.getBean(PersonService.class);
        // Получите Person "Ivan"
        Person ivan = personService.getByName("Иван");
        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());

////        Scanner input = new Scanner(System.in);
////        int number = input.nextInt();
////        int count = 0;
////
////        for (int i = 2; i < number; i++){
////            int prost = 0;
////            for (int j = 2; j<i; j++) {
////                if (i % j == 0) prost += 1;
////                else prost += 0;
////            }
////            if(prost==0) count++;
////        }
////        System.out.println(count);
//
//        char[] arrays = {'б', 'в', 'а'};
//        Arrays.sort(arrays);
//        System.out.println(arrays.length);
//        System.out.println(arrays);
    }
}
