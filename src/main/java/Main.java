import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> setA = new ArrayList<Integer>();
    ArrayList<Integer> setB = new ArrayList<Integer>();
    int size,choice;
    
    System.out.println("Enter size of set: ");
    size = input.nextInt();
    System.out.println("Enter elements of set A: ");
    for(int i = 0;i<size;i++){
      setA.add(input.nextInt());
    }
    System.out.println("Enter elements of set B: ");
    for(int i = 0;i<size;i++){
      setB.add(input.nextInt());
    }

    // setA.add(1);
    // setA.add(2);
    // setA.add(3);
    // setA.add(4);

    // setB.add(6);
    // setB.add(5);
    // setB.add(4);
    // setB.add(3);


    System.out.print("Select one of the following set operations: \n1 - Union\n2 - Intersection\n3 - Subtraction\n4 - Complement\nSelect: ");
    choice = input.nextInt();
    if(choice==1){
      ArrayList<Integer> unionSet = union(setA, setB);
      System.out.println(unionSet);
    }
    else if(choice == 2){
      ArrayList<Integer> intersectionSet = intersect(setA, setB);
      System.out.println(intersectionSet);
    }
    else if(choice==3){
      ArrayList<Integer> subtractSet = subtract(setA, setB);
      System.out.println(subtractSet);
    }
      else if(choice==4){
        ArrayList<Integer> complementSet = complement(setA, setB);
        System.out.println(complementSet);
      }
    else{
      System.out.println();
    }
    
  }

  static ArrayList<Integer> union(ArrayList<Integer> setA, ArrayList<Integer> setB){
    
    ArrayList<Integer> unionSet = new ArrayList<Integer>();
    for(int i = 0;i<setA.size();i++){
      unionSet.add(setA.get(i));
    }

    for(int i = 0;i<setB.size();i++){
      boolean check = false;
      for(int j = 0;j<unionSet.size();j++){
        if(setB.get(i).equals(unionSet.get(j))){
          check = true;
          break;
        }
        
      }
      if(check==false){
        unionSet.add(setB.get(i));
      }
    }
    Collections.sort(unionSet);
    return unionSet;
  }
  static ArrayList<Integer> intersect(ArrayList<Integer> setA, ArrayList<Integer> setB){
    ArrayList<Integer> intersectSet = new ArrayList<Integer>();
    for(int i = 0;i<setA.size();i++){
    boolean check = false;
    for(int j = 0;j<setB.size();j++){
      if(setA.get(i).equals(setB.get(j))){
        check = true;
        break;
      }

    }
    if(check==true){
      intersectSet.add(setB.get(i));
    }
    }
    Collections.sort(intersectSet);
    return intersectSet;
  }


  static ArrayList<Integer> subtract(ArrayList<Integer> setA, ArrayList<Integer> setB){
    ArrayList<Integer> finalSet = new ArrayList<Integer>();
    ArrayList<Integer> errorSet = new ArrayList<Integer>();
    errorSet.add(0);
    int choice;
    Scanner input = new Scanner(System.in);
    System.out.print("Which operation do you want to perform ?\n1) A - B\n2) B - A\nSelect: ");
    choice = input.nextInt();
    if(choice == 1){
      for(int i = 0;i<setA.size();i++){
        boolean found = false;
        for(int j = 0;j<setB.size();j++){
          if(setA.get(i).equals(setB.get(j))){
            found = true;
            break;
          }
        }
        if(found==false){
          finalSet.add(setA.get(i));
        }
      }
      Collections.sort(finalSet);
      return finalSet;
    }

      
    else if(choice==2){
      for(int i = 0;i<setB.size();i++){  
        boolean found = false;
        for(int j = 0;j<setA.size();j++){
          if(setB.get(i)==setA.get(j)){
            found = true;
            break;
          }
        }
        if(found==false){
          finalSet.add(setB.get(i));
        }
      }
      Collections.sort(finalSet);
      return finalSet;
    }
    return errorSet;
  }

  static ArrayList<Integer> complement(ArrayList<Integer> setA, ArrayList<Integer> setB){
    ArrayList<Integer> universalSet = new ArrayList<Integer>();
    ArrayList<Integer> errorSet = new ArrayList<Integer>();
    ArrayList<Integer> finalSet = new ArrayList<Integer>();
    errorSet.add(0);
    int choice;
    Scanner input = new Scanner(System.in);
    System.out.print("Which operation do you want to perform ?\n1) U - A\n2) U - B\nSelect: ");
    choice = input.nextInt();
    if(choice==1){
      System.out.print("Enter size of universal set: ");
      int size = input.nextInt();
      System.out.println("Enter elements of universal set: ");
      for(int i= 0;i<size;i++){
        universalSet.add(input.nextInt());
      }

      for(int i = 0;i<universalSet.size();i++){
        boolean found = false;
        for(int j = 0;j<setA.size();j++){
          if(universalSet.get(i).equals(setA.get(j))){
            found = true;
            break;
          }
        }
        if(found==false){
            finalSet.add(universalSet.get(i));
        }
      }
      Collections.sort(finalSet);
      return finalSet;
    }

    if(choice==2){
      System.out.print("Enter size of universal set: ");
      int size = input.nextInt();
      System.out.println("Enter elements of universal set: ");
      for(int i= 0;i<size;i++){
        universalSet.add(input.nextInt());
      }

      for(int i = 0;i<universalSet.size();i++){
        boolean found = false;
        for(int j = 0;j<setB.size();j++){
          if(universalSet.get(i).equals(setB.get(j))){
            found = true;
            break;
          }
        }
        if(found==false){
            finalSet.add(universalSet.get(i));
        }
      }
      Collections.sort(finalSet);
      return finalSet;
    }
    return errorSet;
  }
}