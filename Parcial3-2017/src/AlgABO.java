

public class AlgABO implements IAlgABO{
    int[][] W;
    int[][] P;
    int[][] R;

    
    @Override 
    public void EncontrarOptimo(int cantElem, int[] frecExito, int[] frecNoExito) {
        int i, j, k, kraiz, h;
        int min;
        kraiz = 0;
/*
* paso 1, h = 0, wii = bii y pii = wii
*/
        h=0;
        this.crearMatrices(cantElem);
        for (int e=0 ;e<W.length ;e++){
            W[e][e]=frecNoExito[e];
            P[e][e]=frecNoExito[e];
        }
    
/* paso 2 wij = wii+ aj + bj
*/
        for(int f=0;f<cantElem;f++){
            for(int c=f+1 ; c<cantElem+1 ;c++){
                W[f][c]=W[f][c-1]+frecExito[c]+frecNoExito[c];
            }
        }
/*paso 3 h = 1 pij = wij + pii + pjj
*/
        h=1;
        for(int f=0 ;f<cantElem ;f++){
            int c=f+1;
            P[f][c]=W[f][c]+P[f][f]+P[c][c];
            R[f][c]=c;
        }
        System.out.println("-----------W------------");
        this.imprimirMatriz(W);
        System.out.println("-----------P------------");

    
// h = 2 hasta h = n
        kraiz = 0;
        for (h = 2; h < cantElem + 1; h++) {
            for (i = 0; i < cantElem - h + 1; i++) {
                j = i + h;
                min = Integer.MAX_VALUE;
                
                for(int w=i+1;w<j+1;w++){
                    int res=P[i][w-1]+P[w][j];
                    if(res<min){
                        min=res;
                        kraiz=w;
                    }
                }
                P[i][j] = min + W[i][j];
                R[i][j] = kraiz;
            }
        }
        this.imprimirMatriz(P);
        System.out.println("------------R-----------");
        this.imprimirMatriz(R);
    }
    
    
    @Override
    //public void ArmarArbolBinario(int i, int j, String[] Claves, TArbolBB elArbolBB) {
    public void ArmarArbolBinario(int i, int j, String[] Claves, TArbolBB elArbolBB) {
        TElementoAB unNodo;
        int unaraiz;
        if (i < j) {
            unaraiz = R[i][j];
            unNodo=new TElementoAB(Claves[unaraiz],elArbolBB);
            elArbolBB.insertar(unNodo);
            ArmarArbolBinario(i,unaraiz-1,Claves,elArbolBB);
            ArmarArbolBinario(unaraiz,j,Claves, elArbolBB);
        }
    }
    
    public AlgABO(int cantElem) {
        crearMatrices(cantElem);
    }
   
    private void crearMatrices(int cantElem) {
        W = new int[cantElem + 1][cantElem + 1];
        P = new int[cantElem + 1][cantElem + 1];
        R = new int[cantElem + 1][cantElem + 1];
    }

    public void imprimirMatriz(int[][] matriz){
        for(int i=0;i<matriz.length;i++){
            String aImprimir="";
            for(int j=0;j<matriz.length;j++){
                aImprimir+=matriz[i][j]+", ";
            }
            System.out.println(aImprimir);
        }    
    }

}