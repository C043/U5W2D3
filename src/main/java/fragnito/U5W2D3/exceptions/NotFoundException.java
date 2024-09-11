package fragnito.U5W2D3.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(int id) {
        System.out.println("L'entità con id: " + id + " non è stata trovata.");
    }
}
