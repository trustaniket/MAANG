import javax.lang.model.type.ArrayType;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeProgram {


    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setId("wal101");
        employee1.setName("Zebra");
        employee1.setDesignation("Engineer");

        Employee employee3 = new Employee();
        employee3.setId("wal103");
        employee3.setName("Madhu");
        employee3.setDesignation("Engineer");

        Employee employee2 = new Employee();
        employee2.setId("wal102");
        employee2.setName("Raghav");
        employee2.setDesignation("Engineer");

        Map<Integer, Employee> map = new HashMap<>();
        map.put(1, employee1);
        map.put(2, employee2);
        map.put(3, employee3);

        EmployeeProgram employeeProgram = new EmployeeProgram();
        Map<Integer, Employee> output = employeeProgram.sortEmployees(map);

        for(Employee employee : output.values()){
            System.out.println(employee.getName());
        }
    }

    public Map<Integer, Employee> sortEmployees(Map<Integer, Employee> map){




        Map<Integer, Employee> output = new LinkedHashMap<>();
        List<Map.Entry<Integer, Employee>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Map.Entry.comparingByValue());

        for(Map.Entry<Integer, Employee> entry : list){
            output.put(entry.getKey(), entry.getValue());
        }


        return output;
    }





    static class Employee implements Comparable<Employee>{
        String id;
        String name;
        String designation;



        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        @Override
        public int compareTo(Employee o) {
            return this.getName().compareTo(o.getName());
        }
    }

}
