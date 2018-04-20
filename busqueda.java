import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
public class busqueda {
    public static String mostrar[]=new String[tokens.cuenta+1];
    public static String variables[][]=new String[100][3];
    public static int cont =0,pos=0,pos2=0,pos3=0;
    public static ArrayList lista=new ArrayList();
    public static ArrayList listaoptima=new ArrayList();
    public static ArrayList arrayoptimo=new ArrayList();
    public static void expConstantes() {
        String arreExpCom[][]=new String[100][100];
        int i = 0, j = 0, l = 0;    
        while(!tokens.arregloshido[i].equals("fin")){
            if((tokens.arregloshido[i].equals("=")) && (!tokens.arregloshido[i-2].equals("entero")) && (!tokens.arregloshido[i-2].equals(",")) && !tokens.arregloshido[i-2].equals("decimal") && !tokens.arregloshido[i-2].equals("cadena")){
                i--;
                while(!tokens.arregloshido[i].equals("#")){
                    arreExpCom[j][l] = tokens.arregloshido[i];
                    mostrar[pos]=arreExpCom[j][l];
                    lista.add(arreExpCom[j][l]);
                    pos++;
//                    System.out.println(arreExpCom[j][l]);
                    i++; l++;
                }                   
//                procesa(mostrar);
                procesa(lista);
                lista=new ArrayList();
                arreExpCom[j][l] = tokens.arregloshido[i];//#
                j++; l=0; pos=0;
            }
            i++;
//            System.out.println();
        }
    }
    public static void procesa(ArrayList mostrar) {
        String resuelve="";
        int tam=mostrar.size();
        boolean ban=true;
//        System.out.println("\ntam= "+tam);
        if(tam==3) {
            try {
                int a=Integer.parseInt(""+mostrar.get(2));
            }catch(NumberFormatException e) {
                try {
                    double b=Double.parseDouble(""+mostrar.get(2));
                }catch(NumberFormatException ex) {
                    ban=false;
                }
            }
            if(ban==true) {
                System.out.println();
                for (int j = 0; j < 3; j++) {
                    variables[pos2][j]=""+mostrar.get(j);
                }
                pos2++;
            }
        } else {
            for (int i = 0; i < 100; i++) {
//                System.out.println();
                if (variables[i][0] != null) {
                    for (int j = 2; j < mostrar.size(); j++) {
                        if(variables[i][0].equals(mostrar.get(j))) {
                            mostrar.remove(j);
                            mostrar.add(j,variables[i][2]);
                        }
                    }
//                    System.out.print(variables[i][0]);
                }
            }
            for (int i = 2; i < mostrar.size(); i++) {
                if(mostrar.get(i)!=null) {
                    resuelve=resuelve+mostrar.get(i);
                }
            }
//            resuelve="("+resuelve+")";
            System.out.println("\nOperacion: "+resuelve);

            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            try {
//                String optima=mostrar.get(0)+" = "+engine.eval(resuelve);
                String optima=""+engine.eval(resuelve);
                System.out.println("optima= "+optima);
                listaoptima.add(mostrar.get(0));
                pos3++;
                listaoptima.add("=");
                pos3++;
                listaoptima.add(optima);
                pos++;
                for (int k = 0; k < listaoptima.size(); k++) {
                    System.out.print(listaoptima.get(k));
                }
                mostrar(listaoptima);
                listaoptima=new ArrayList();
            } catch (ScriptException ex) {
                System.out.println("No se encontró una pareja que coincida con tus criterios");
            }
        }
    }
    public static void mostrar(ArrayList listaoptima) {
        int posi=0,posi2=0,posi3=0;
        System.out.println();
        while(!tokens.arregloshido[posi].equals("fin")) {
            if(listaoptima.get(0).equals(tokens.arregloshido[posi]) && tokens.arregloshido[posi-1].equals("#") && !tokens.arregloshido[posi+3].equals("#")) {
                posi2=posi;
//                System.out.println("IGUALES");
                while(!tokens.arregloshido[posi2].equals("#")) {
                    tokens.arregloshido[posi2]="";
                    if(posi3<3) {
                        tokens.arregloshido[posi2]=""+listaoptima.get(posi3);
                    }
                    posi2++;
                    posi3++;
                }
            }
//            System.out.println(tokens.arre3[posi]);
            arrayoptimo.add(posi, tokens.arregloshido[posi]);
            posi++;
        }
        for (int i = 0; i < posi; i++) {
            if(arrayoptimo.get(i) != "") {
//                System.out.println(arrayoptimo.get(i));
                tokens.arregloshido[i]=""+arrayoptimo.get(i);
            }
        }
    }
}