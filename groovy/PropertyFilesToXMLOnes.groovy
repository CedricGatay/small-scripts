import groovy.io.FileType
/**
 * User: cgatay
 * Date: 09/04/13
 * Time: 17:24
 */

def filesToConvert = []
def parentDir = new File(".")
parentDir.eachFileRecurse(FileType.FILES){ file ->
    if (file.name.endsWith("_fr.properties")){
        filesToConvert << file
    }
}

for (File f : filesToConvert) {
    println("Going to convert :  ${f.name}")
    Properties props = new Properties();
    props.load(new FileReader(f))

    OutputStream os = new FileOutputStream("${f.parentFile.path}${File.separatorChar}${f.name}.xml");

    //store the properties detail into a pre-defined XML file
    props.storeToXML(os, "","UTF-8");
}

