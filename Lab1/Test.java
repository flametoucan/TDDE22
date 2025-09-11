public class Test {
    public static void main(final String[] args){
        int tableSize = 10;
        SymbolTable st = new SymbolTable(nextInt(tableSize)) 

        if(st.isEmpty != True){
            st.dump();
        } else{
            //en syso här om att listan inte var tom vid start
        }

        try{
            st.get(shjkahdlasj)
        } catch("idk vad som ska stå här"){
            //en syso om att man får ut värde när inget ska finnas
        }

        try{
            st.put( ,2)
        } catch("idk vad som ska stå här"){
        //en syso här som sgäer att man försöker sätta in key med null namn
        }

        st.put("volvo",142);

        if(st.contains(volvo) == False){
            //en syso här som säger att put funktionen inte fungerar
        }

        if(st.get(volvo) != 142){
            //en syso om att get funktionen inte lägger inte värde korrekt
        }

        if(st.size() != 1){
            //en syso om att det finns element i arrayen som inte ska vara där (kanske vär o ha en dump här?)
        }

        st.delete(volvo);

        if(st.contains(volvo) == True){
            //en syso här om att delete inte fungerar
        }

        st.put("sko",40);
        st.put("sko", 45);

        if(st.get(sko) != 45){
            //syso om att key värde inte uppdateras korrekt
            if(st.get(sko) == 40){
                //syso om att sko inte uppdateras alls
            }
        }

        st.delete(sko);

        st.put("hej", h);
        st.put("ejh", e);
        st.put("jhe", j);

        if(st.size() != 3){
            //syso här om att put av key med samma hash inte fungerar korrekt
        }
        if(st.size() >= 4){
            //syso här om att delete inte fungarar som de ska
        }

        if(st.get(hej) != h || st.get(ejh) != e || st.get(jhe) != j){
            //en syso här om att någon del i hashprocessen inte fungerar. Man kan nog dela upp detta i tre olika steg
        }

        st.delete(hej);
        st.delete(ejh);
        st.delete(jhe);

        st.put("cuh", c);
        st.put("uhc", u);
        st.put("hcu", h);

    }
}