
/**
 *
 * @author Ernesto
 */
public class CalculadorMatricesOptimo implements ICalculadorMatricesOptimo {

    int[][] w;
    int[][] p;
    int[][] r;

    public CalculadorMatricesOptimo(int cantElem) {
        crearMatrices(cantElem);
    }

    private void crearMatrices(int cantElem) {
        this.w = new int[cantElem + 1][cantElem + 1];
        this.p = new int[cantElem + 1][cantElem + 1];
        this.r = new int[cantElem + 1][cantElem + 1];
    }

    @Override
    public void encontrarOptimo(int cantElem, int[] frecExito, int[] frecNoExito) {
        int i, j, k, kraiz, h, min, pesoSubArboles;
        kraiz = 0;

        //h = 0
        for (i = 0; i <= cantElem; i++) {
            this.w[i][i] = frecNoExito[i];
            this.p[i][i] = frecNoExito[i];
        }

        for (i = 0; i <= cantElem; i++) {
            for (j = 1; j < frecNoExito.length; j++) {
                if (i < j) {
                    w[i][j] = w[i][j - 1] + frecNoExito[j] + frecExito[j];
                }
            }
        }
        //h = 1
        j = 0;
        for (i = 0; i < cantElem; i++) {
            j = i + 1;
            this.p[i][j] = w[i][j] + p[i][i] + p[j][j];
            r[i][j] = j;
        }
        //h > 1
        for (h = 2; h < cantElem + 1; h++) {
            for (i = 0; i < cantElem - h + 1; i++) {
                j = i + h;
                min = Integer.MAX_VALUE;
                for (k = i + 1; k <= j; k++) {
                    pesoSubArboles = p[i][k - 1] + p[k][j];
                    if (pesoSubArboles < min) {
                        min = pesoSubArboles;
                        kraiz = k;
                    }
                }
                p[i][j] = min + w[i][j];
                r[i][j] = kraiz;
            }
        }
    }

    @Override
    public void armarArbolBinario(int i, int j, String[] claves, TArbolBB elArbolBB) {
        TElementoAB unNodo;
        int unaRaiz;
        if (i < j) {
            unaRaiz = r[i][j];
            unNodo = new TElementoAB(claves[unaRaiz],unaRaiz );
            elArbolBB.insertar(unNodo);
            armarArbolBinario(i, unaRaiz - 1, claves, elArbolBB);
            armarArbolBinario(unaRaiz, j, claves, elArbolBB);
        }
    }

}
