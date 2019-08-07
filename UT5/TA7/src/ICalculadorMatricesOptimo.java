
public interface ICalculadorMatricesOptimo {

    //public int calcularCosto();
    void armarArbolBinario(int i, int j, String[] Claves, TArbolBB elArbolBB);

    public void encontrarOptimo(int cantElem, int[] FrecExito, int[] FrecNoExito);

}
