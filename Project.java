import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Student
{
    private String studentId;
    private String name;
    public Student(String studentId, String name)
    {
        this.studentId = studentId;
        this.name = name;
    }
    public String getStudentId()
    {
        return studentId;
    }
    public String getName()
    {
        return name;
    }
}
class Room 
{
    private int roomNumber;
    private boolean isOccupied;
    public Room(int roomNumber) 
    {
        this.roomNumber = roomNumber;
        this.isOccupied = false;
    }
    public int getRoomNumber()
    {
        return roomNumber;
    }
    public boolean isOccupied() 
    {
        return isOccupied;
    }
    public void occupyRoom() 
    {
        isOccupied = true;
    }
    public void vacateRoom()
    {
        isOccupied = false;
    }
}
class HostelManagementSystem
{
    private List<Student> students;
    private List<Room> rooms;
    public HostelManagementSystem()
    {
        this.students = new ArrayList<>();
        this.rooms = new ArrayList<>();
        initializeRooms();
        initializeRooms1();
        initializeRooms2();
    }
    private void initializeRooms()
    {
        for (int i = 1; i <= 10; i++)
        {
            Room room = new Room(i);
            rooms.add(room);
        }
    }
    private void initializeRooms1()
    {
        for(int j = 101; j <= 110; j++)
        {
            Room room = new Room(j);
            rooms.add(room);
        }
    }
    private void initializeRooms2()
    {
        for(int z =201; z <= 210; z++)
        {
            Room room = new Room(z);
            rooms.add(room);
        }
    }
    public void displayAvailableRooms() {
        System.out.println("Available Rooms:\n");
        for (Room room : rooms)
        {
            if (!room.isOccupied())
            {
                System.out.println("Room " + room.getRoomNumber());
            }
        }
    }
    public void admitStudent(String studentId, String studentName, int roomNumber)
    {
        Room selectedRoom = getRoomByNumber(roomNumber);

        if (selectedRoom != null && !selectedRoom.isOccupied()) 
        {
            Student student = new Student(studentId, studentName);
            students.add(student);
            selectedRoom.occupyRoom();
            System.out.println("Admission successful. Student " + studentName + " assigned to Room " + roomNumber);
        }
        else 
        {
            System.out.println("Invalid room selection or room already occupied.");
        }
    }
    private Room getRoomByNumber(int roomNumber)
    {
        for (Room room : rooms) 
        {
            if (room.getRoomNumber() == roomNumber)
            {
                return room;
            }
        }
        return null;
    }
}
class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        HostelManagementSystem hostelSystem = new HostelManagementSystem();
        hostelSystem.displayAvailableRooms();
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter student name: ");
        String studentName = scanner.next();
        System.out.print("Enter the room number for admission: ");
        int roomNumber = scanner.nextInt();
        hostelSystem.admitStudent(studentId ,studentName, roomNumber);
    }
}
