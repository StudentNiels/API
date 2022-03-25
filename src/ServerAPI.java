
public class ServerAPI extends Parser{
    /**
     *
     * Alle jsons zouden moeten werken
     * 2015_test.xml levert een rauw resultaat
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String filePath = "resources/2015_test.xml";
        Parser parser = new Parser();
        String ext = getExtension(filePath);
        if(ext.equals("json") )
        {
            parser.parseJsonFile(filePath);
        }
        if (ext.equals("xml")){
            parser.parseXmlFile(filePath);
        } else {
            System.out.println("No file is recognised");
        }

    }

    public static String getExtension(String filePath)
    {
        String extension = "";

        int i = filePath.lastIndexOf('.');
        if (i > 0) {
            extension = filePath.substring(i+1);
        }
        return extension;
    }
}

