package sistemateatromoro;

import java.util.Scanner;

/**
 *
 * @author Kevin Rojas
 */
public class SistemaTeatroMoro{

    public class PreciosPromoTeatro{
        //variables referentes a los precios y promociones
        public static int precioEntrVip = 20000;
        public static int precioEntrPlat = 15000;
        public static int precioEntrGnrl = 10000;
        public static int totalEntradasVend = 0;
        public static int iva = 19;
        
        public static int precioFinal = 0;
        public static int descEst = 10;
        public static int descTerEdad = 15;
        public static int noDesc = 0;
        public static String entradaTipoBoleta = "";
        public static String tipoPromoBoleta = "";
        
        public static String promo1 = "[1]-Promo Estudiante: ";
        public static String promo2 = "[2]-Promo Tercera Edad: ";
        public static String noPromo = "[3] No aplicar promocion"; 
    }
    
    public class AsientosTeatro{
       //asientos de teatro: true = disponibles y false = no disponibles, validacion de asientos y numeros
       public static String nombreasientoTeatro0 = "Asiento 1 ";
       public static String nombreasientoTeatro1 = "Asiento 2 ";
       public static String nombreasientoTeatro2 = "Asiento 3 ";
       public static String nombreasientoTeatro3 = "Asiento 4 ";
       public static String nombreasientoTeatro4 = "Asiento 5 ";
       public static boolean asientoTeatro0 = true;
       public static boolean asientoTeatro1 = true;
       public static boolean asientoTeatro2 = true;
       public static boolean asientoTeatro3 = true;
       public static boolean asientoTeatro4 = true;
       public static int numAsiento = 0;
       public static boolean validarAsiento = false;
       public static String ubicaAsiento = "";      
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        //variables tipo de entrada
        String entrVip = "[1]-VIP";
        String entrPlat = "[2]-PLATEA";
        String entrGnrl = "[3]-GENERAL";
        
        int tipoPromo = 0;
        int precioFinal = 0;
        int ivaBoleta = 0;
        
        do{
            System.out.println("""
                                [1] Venta de Entradas
                                [2] Imprimir boleta
                                [0] Salir del sistema
                                Ingresar opcion:""");
            int opmenu = scanner.nextInt();
            switch(opmenu){
                case 1->{
                    System.out.println(entrVip); //1
                    System.out.println(entrPlat);//2
                    System.out.println(entrGnrl);//3
                    int tipoEntrada = scanner.nextInt();
                    switch(tipoEntrada){
                        case 1,2,3 ->{
                            System.out.println(PreciosPromoTeatro.promo1 + "Descuento: " + PreciosPromoTeatro.descEst + "%");
                            System.out.println(PreciosPromoTeatro.promo2 + "Descuento: " + PreciosPromoTeatro.descTerEdad + "%");
                            System.out.println(PreciosPromoTeatro.noPromo);
                            tipoPromo = scanner.nextInt();
                            if (tipoPromo == 1 || tipoPromo == 2 || tipoPromo == 3){
                                System.out.println("Disponibilidad de asientos:");
                                System.out.println(AsientosTeatro.nombreasientoTeatro0 + (AsientosTeatro.asientoTeatro0 ? "Disponible" : "Ocupado"));
                                System.out.println(AsientosTeatro.nombreasientoTeatro1 + (AsientosTeatro.asientoTeatro1 ? "Disponible" : "Ocupado"));
                                System.out.println(AsientosTeatro.nombreasientoTeatro2 + (AsientosTeatro.asientoTeatro2 ? "Disponible" : "Ocupado"));
                                System.out.println(AsientosTeatro.nombreasientoTeatro3  + (AsientosTeatro.asientoTeatro3 ? "Disponible" : "Ocupado"));
                                System.out.println(AsientosTeatro.nombreasientoTeatro4 + (AsientosTeatro.asientoTeatro4 ? "Disponible" : "Ocupado"));                               
                                System.out.println("Ingrese el asiento: ");
                                AsientosTeatro.numAsiento = scanner.nextInt();                               
                                switch (AsientosTeatro.numAsiento)
                                { //validar los asientos
                                    case 1 ->
                                    {
                                        AsientosTeatro.validarAsiento = AsientosTeatro.asientoTeatro0;
                                        AsientosTeatro.ubicaAsiento = AsientosTeatro.nombreasientoTeatro0;
                                        AsientosTeatro.asientoTeatro0 = false;
                                    }
                                    case 2 ->
                                    {
                                        AsientosTeatro.validarAsiento = AsientosTeatro.asientoTeatro1;
                                        AsientosTeatro.ubicaAsiento = AsientosTeatro.nombreasientoTeatro1;
                                        AsientosTeatro.asientoTeatro1 = false;
                                    }
                                    case 3 ->
                                    {
                                        AsientosTeatro.validarAsiento = AsientosTeatro.asientoTeatro2;
                                        AsientosTeatro.ubicaAsiento = AsientosTeatro.nombreasientoTeatro2;
                                        AsientosTeatro.asientoTeatro2 = false;
                                    }
                                    case 4 ->
                                    {
                                        AsientosTeatro.validarAsiento = AsientosTeatro.asientoTeatro3;
                                        AsientosTeatro.ubicaAsiento = AsientosTeatro.nombreasientoTeatro3;
                                        AsientosTeatro.asientoTeatro3 = false;
                                    }
                                    case 5 -> 
                                    {
                                        AsientosTeatro.validarAsiento = AsientosTeatro.asientoTeatro4;
                                        AsientosTeatro.ubicaAsiento = AsientosTeatro.nombreasientoTeatro4;
                                        AsientosTeatro.asientoTeatro4 = false;
                                    }
                                    default -> System.out.println("Asiento no disponible");                                  
                                }                     
                                if ((AsientosTeatro.validarAsiento) && tipoEntrada == 1 && tipoPromo == 1){ //validacion entrada VIP + ESTUDIANTE
                                    System.out.println(PreciosPromoTeatro.promo1 + "Descuento: " + PreciosPromoTeatro.descEst + "%");
                                    precioFinal = PreciosPromoTeatro.precioEntrVip - (PreciosPromoTeatro.descEst*PreciosPromoTeatro.precioEntrVip)/100;
                                    System.out.println("Precio final " + precioFinal);
                                    AsientosTeatro.validarAsiento = false;
                                    ivaBoleta = (precioFinal*PreciosPromoTeatro.iva)/100;
                                    PreciosPromoTeatro.entradaTipoBoleta = entrVip;
                                    PreciosPromoTeatro.tipoPromoBoleta = PreciosPromoTeatro.promo1;
                                }
                                else if((AsientosTeatro.validarAsiento) && tipoEntrada == 1 && tipoPromo == 2){ //validacion entrada VIP + TERCERA EDAD
                                    System.out.println(PreciosPromoTeatro.promo2 + "Descuento: " + PreciosPromoTeatro.descTerEdad + "%");
                                    precioFinal = PreciosPromoTeatro.precioEntrVip - (PreciosPromoTeatro.descTerEdad*PreciosPromoTeatro.precioEntrVip)/100;
                                    System.out.println("Precio final " + precioFinal);
                                    AsientosTeatro.validarAsiento = false;
                                    ivaBoleta = (precioFinal*PreciosPromoTeatro.iva)/100;
                                    PreciosPromoTeatro.entradaTipoBoleta = entrVip;
                                    PreciosPromoTeatro.tipoPromoBoleta = PreciosPromoTeatro.promo2;
                                }
                                else if((AsientosTeatro.validarAsiento) && tipoEntrada == 1 && tipoPromo == 3){ //validacion entrada VIP SIN DESCUENTO
                                    System.out.println(PreciosPromoTeatro.noPromo + "Descuento: " + PreciosPromoTeatro.noDesc + "%");
                                    precioFinal = PreciosPromoTeatro.precioEntrVip;
                                    System.out.println("Precio final " + precioFinal);
                                    AsientosTeatro.validarAsiento = false;
                                    ivaBoleta = (precioFinal*PreciosPromoTeatro.iva)/100;
                                    PreciosPromoTeatro.entradaTipoBoleta = entrVip;
                                    PreciosPromoTeatro.tipoPromoBoleta = PreciosPromoTeatro.noPromo;
                                }
                                else if((AsientosTeatro.validarAsiento) && tipoEntrada == 2 && tipoPromo == 1){ //validacion entrada PLATEA + ESTUDIANTE
                                    System.out.println(PreciosPromoTeatro.promo2 + "Descuento: " + PreciosPromoTeatro.descEst + "%");
                                    precioFinal = PreciosPromoTeatro.precioEntrPlat - (PreciosPromoTeatro.descEst*PreciosPromoTeatro.precioEntrPlat)/100;
                                    System.out.println("Precio final " + precioFinal);
                                    AsientosTeatro.validarAsiento = false;
                                    ivaBoleta = (precioFinal*PreciosPromoTeatro.iva)/100;
                                    PreciosPromoTeatro.entradaTipoBoleta = entrPlat;
                                    PreciosPromoTeatro.tipoPromoBoleta = PreciosPromoTeatro.promo1;
                                }
                                else if((AsientosTeatro.validarAsiento) && tipoEntrada == 2 && tipoPromo == 2){ //validacion entrada PLATEA + TERCERA EDAD
                                    System.out.println(PreciosPromoTeatro.promo2 + "Descuento: " + PreciosPromoTeatro.descTerEdad + "%");
                                    precioFinal = PreciosPromoTeatro.precioEntrPlat - (PreciosPromoTeatro.descTerEdad*PreciosPromoTeatro.precioEntrPlat)/100;
                                    System.out.println("Precio final " + precioFinal);
                                    AsientosTeatro.validarAsiento = false;
                                    ivaBoleta = (precioFinal*PreciosPromoTeatro.iva)/100;
                                    PreciosPromoTeatro.entradaTipoBoleta = entrPlat;
                                    PreciosPromoTeatro.tipoPromoBoleta = PreciosPromoTeatro.promo2;
                                }
                                else if((AsientosTeatro.validarAsiento) && tipoEntrada == 2 && tipoPromo == 3){ //validacion entrada PLATEA + SIN DESCUENTO
                                    System.out.println(PreciosPromoTeatro.noPromo + "Descuento: " + PreciosPromoTeatro.noDesc + "%");
                                    precioFinal = PreciosPromoTeatro.precioEntrPlat;
                                    AsientosTeatro.validarAsiento = false;
                                    ivaBoleta = (precioFinal*PreciosPromoTeatro.iva)/100;
                                    PreciosPromoTeatro.entradaTipoBoleta = entrPlat;
                                    PreciosPromoTeatro.tipoPromoBoleta = PreciosPromoTeatro.noPromo;
                                }
                                else if ((AsientosTeatro.validarAsiento) && tipoEntrada == 3 && tipoPromo == 1){ //validacion entrada GENERAL + ESTUDIANTE
                                    System.out.println(PreciosPromoTeatro.promo1 + "Descuento: " + PreciosPromoTeatro.descEst + "%");
                                    precioFinal = PreciosPromoTeatro.precioEntrGnrl - (PreciosPromoTeatro.descEst*PreciosPromoTeatro.precioEntrGnrl)/100;
                                    System.out.println("Precio final " + precioFinal);
                                    AsientosTeatro.validarAsiento = false;
                                    ivaBoleta = (precioFinal*PreciosPromoTeatro.iva)/100;
                                    PreciosPromoTeatro.entradaTipoBoleta = entrGnrl;
                                    PreciosPromoTeatro.tipoPromoBoleta = PreciosPromoTeatro.promo1;
                                }
                                else if((AsientosTeatro.validarAsiento) && tipoEntrada == 3 && tipoPromo == 2){ //validacion entrada GENERAL + TERCERA EDAD
                                    System.out.println(PreciosPromoTeatro.promo2 + "Descuento: " + PreciosPromoTeatro.descTerEdad + "%");
                                    precioFinal = PreciosPromoTeatro.precioEntrGnrl - (PreciosPromoTeatro.descTerEdad*PreciosPromoTeatro.precioEntrGnrl)/100;
                                    System.out.println("Precio final " + precioFinal);
                                    AsientosTeatro.validarAsiento = false;
                                    ivaBoleta = (precioFinal*PreciosPromoTeatro.iva)/100;
                                    PreciosPromoTeatro.entradaTipoBoleta = entrGnrl;
                                    PreciosPromoTeatro.tipoPromoBoleta = PreciosPromoTeatro.promo2;
                                }
                                else if((AsientosTeatro.validarAsiento) && tipoEntrada == 3 && tipoPromo == 3){ //validacion entrada GENERAL + SIN DESCUENTO
                                    System.out.println(PreciosPromoTeatro.noPromo + "Descuento: " + PreciosPromoTeatro.noDesc + "%");
                                    precioFinal = PreciosPromoTeatro.precioEntrGnrl;
                                    AsientosTeatro.validarAsiento = false;
                                    ivaBoleta = (precioFinal*PreciosPromoTeatro.iva)/100;
                                    PreciosPromoTeatro.entradaTipoBoleta = entrGnrl;
                                    PreciosPromoTeatro.tipoPromoBoleta = PreciosPromoTeatro.noPromo;
                                }
                                else{
                                    System.out.println("Asiento no disponible");
                                }
                            }else{ //else tipoPromo
                                System.out.println("Ingrese una opcion valida...");
                            }
                        }//end switch tipoEntrada-case 1,2,3 tipoEntrada
                        default -> System.out.println("Ingese una opcion valida");
                    }//end swich tipoEntrada    
                }//end case 1 opmenu
                case 2 -> {
                    System.out.println("#####################################");
                    System.out.println("       BOLETA TEATRO MORO            ");
                    System.out.println("#####################################");
                    System.out.println("Detalle:");
                    System.out.println("Entrada: " + PreciosPromoTeatro.entradaTipoBoleta);
                    System.out.println("Descuento: " + PreciosPromoTeatro.tipoPromoBoleta);                  
                    System.out.println("Ubicacion: " + AsientosTeatro.ubicaAsiento);
                    System.out.println("Total a pagar:" + precioFinal);
                    System.out.println("Iva: " + ivaBoleta);
                    System.out.println("#####################################");
                }
                case 0 ->{
                    System.out.println("Saliendo del sistema");
                    salir = true;
                }
            }//end switch opmenu           
        }while(!salir);
        scanner.close();
    }//end main    
}//end class