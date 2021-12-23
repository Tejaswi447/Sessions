package session3_exceptions;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandling {

    public static void main(String[] args){
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "/Users/a563672/IdeaProjects/StreamsUsingCollections/src/calEngine/demoCalculations.txt"))) {
            processFile(reader);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found:" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("error reading file-" + ex.getMessage());
        } catch(InvalidStatementException ex){
           System.out.println(ex.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processFile(BufferedReader reader) throws IOException{
        String InputLine;
        while ((InputLine = reader.readLine()) != null) {
            performOperation(InputLine);
        }
    }

    private static void performOperation(String InputLine) {
        String[] parts = InputLine.split(" ");
        if(parts.length!=3){
            throw new InvalidStatementException("the statement must contain three parts");
        }
        String operation = parts[0].toUpperCase();
        int leftVal = Integer.parseInt(parts[1]);
        int rightVal = Integer.parseInt(parts[2]);
        int result = execute(operation, leftVal, rightVal);
        System.out.println(InputLine + "=" + result);
    }

    static int execute(String operation, int leftVal, int rightVal) {
        int result = 0;
        switch (operation) {
            case "ADDITION":
                result = leftVal + rightVal;
                break;
            case "SUBSTRACTION":
                result = leftVal - rightVal;
                break;
            case "MULTIPLICATION":
                result = leftVal * rightVal;
                break;
            case "DIVISION":
                if (rightVal == 0) {
                   /** IllegalArgumentException exception =
                            new IllegalArgumentException("zero rightval is not permitted with division");
                    throw exception;*/
                   throw new IllegalArgumentException("zero rightval is not permitted with division");
                }
                result = leftVal / rightVal;
                break;
        }
        return result;
    }


}
