import java.io.File;

class TraverseDirectory {
    public static long size;

    public static void main(String[] args) {
        File directory = new File("F:\\Directory-Analysis\\MainDir");
        System.out.println("All Files And Directory :");
        listingFiles(directory);
        System.out.println("************************************************************************");
        System.out.println("Displaying All TXT Files");
        listingTXTFiles(directory);

                System.out.println("************************************************************************");

        System.out.println("length of all .txt  files is " + size + " bytes");

    }

    public static void listingFiles(File arr) {
    File[] fileArr = arr.listFiles();

    if (fileArr != null) {
    for (File file : fileArr) {

    if (file.isDirectory()) {
    System.out.println("Directory :" + file.getAbsolutePath());
    listingFiles(file);
    } else {

    System.out.println("File :" + file.getAbsolutePath());
    }
    }
    }
    }

    public static void listingTXTFiles(File arr) {
        File[] fileArr = arr.listFiles();

        if (fileArr != null) {
            for (File file : fileArr) {

                if (file.isDirectory()) {
                    // System.out.println("Directory :" + file.getAbsolutePath());
                    listingTXTFiles(file);

                } else {
                    if (file.getName().contains(".txt")) {
                        System.out.println("File :" + file.getAbsolutePath());
                        size += file.length();

                    }

                }
            }
        }
    }
    
}