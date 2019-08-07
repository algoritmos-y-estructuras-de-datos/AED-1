
import java.util.Iterator;
import java.util.LinkedList;


public class PlantillaMedicos extends TArbolBB<Medico> implements IPlantillaMedicos {

    @Override
    public DirectorioEspecialidad obtenerDirectorio(String laEspecialidad) {

        DirectorioEspecialidad retorno = new DirectorioEspecialidad();

        LinkedList<Medico> medicos = this.inOrden();
        for (Medico medico : medicos) {
            if (medico.getEspecialidad().equals(laEspecialidad))
                retorno.insertar(new TElementoAB<>(medico.getNombre(), medico));
        }
        
        return retorno;
    }

}
