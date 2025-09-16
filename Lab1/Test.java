public class Test {
    public static void main(final String[] args){
        int tableSize = 10;
        SymbolTable st = new SymbolTable(tableSize);

        if(st.isEmpty() != true){
            st.dump();
            //en syso här om att listan inte var tom vid start
            System.out.println("");
        }

        try {
            st.get("shjkahdlasj"); 
        } catch (Exception e) {
            System.out.println("Försökte hämta ett värde som inte finns.");
        }

        try{
            st.put( null,'b');
        } catch(NullPointerException e){
            //en syso här som sgäer att man försöker sätta in key med null namn
            System.out.println(e);
        }
        
        st.put("volvo", 'v');

        if(st.contains("volvo") == false){
            System.out.println("put fungerar ej lol!!!!!! B)");
        }
            //en syso här som säger att put funktionen inte fungerar

        if(st.get("volvo") != 'v'){
            //en syso om att get funktionen inte lägger inte värde korrekt
            System.out.println("put lägger inte till värde korrekt");
        }
    
        if(st.size() != 1){
            //en syso om att det finns element i arrayen som inte ska vara där (kanske vär o ha en dump här?)
            System.out.println(st.size() + " det finns element som inte hör hemma i arrayen");
        }

        st.delete("volvo");

        if(st.contains("volvo") == true){
            //en syso här om att delete inte fungerar
        }

        st.put("sko",'s');
        st.put("sko", 'b');

        if(st.get("sko") != 'b'){
            //syso om att key värde inte uppdateras korrekt
            if(st.get("sko") == 's'){
                //syso om att sko inte uppdateras alls
            }
        }

        st.put("sko", null);

        if(st.contains("sko") == true){
            System.out.println("tar inte bort om  key updateras med null.");
        }
        st.delete("sko");

        st.put("hej", 'h');
        st.put("ejh", 'e');
        st.put("jhe", 'j');

        if(st.size() != 3){
            //syso här om att put av key med samma hash inte fungerar korrekt
            System.out.println("put with same hash doesnt work correctly");
        }
        if(st.size() >= 4){
            //syso här om att delete inte fungarar som de ska
            System.out.println("delete does not work as intended " + st.size());
        }
        //koden kommer iaf hit
        try{
        if(st.get("hej") != 'h' || st.get("ejh") != 'e' || st.get("jhe") != 'j'){
            //en syso här om att någon del i hashprocessen inte fungerar. Man kan nog dela upp detta i tre olika steg
            System.out.println("some part of the hashprocess does not work");
        }
        }catch(NullPointerException e){
        }

        st.delete("hej");
        st.delete("ejh");
        st.delete("jhe");

        st.put("cuh", 'c');
        st.put("uhc", 'u');
        st.put("hcu", 'h');

        st.put("uhc", 'd');
        if(st.contains("uhc") == false){
            st.dump();
            //syso
            System.out.println("put does not update key correctly");
        }
        else{
            if(st.get("uhc") != 'd'){
                st.dump();
                //syso
                System.out.println("put does not update val correctly ");
            }
        }
        for(int i = 0; i < st.size() + 1; i++){
            st.put("key" + i, (char) ('a' + i));
        }
        if(st.size() != st.size()){
            System.out.println("Error: Expected size " + st.size() + "  but got " + st.size() + "  #id:5522");
        }

        st.delete("uhc");
        System.out.println();
        if(st.contains("cuh") != true || st.contains("hcu") != true){
            System.out.println("Deletion is wrong");
        }

        System.out.println("-----------------------------------------------------");
        if(st.get("cuh") != 'c' || st.get("hcu") != 'h'){
            System.out.println("Error: Expected 'c', 'h' but got " + st.get("cuh") + ", " + ", " + st.get("hcu"));
        }
        System.out.println("all kod körs");
    }
}