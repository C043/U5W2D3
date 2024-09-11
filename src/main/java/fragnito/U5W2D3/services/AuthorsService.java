package fragnito.U5W2D3.services;

import fragnito.U5W2D3.entities.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorsService {
    private final List<Author> authorList = new ArrayList<>();

    public List<Author> getAuthorList(){
        return this.authorList;
    }

    public Author findAuthorById(int authorId){
        return authorList.stream().filter(author -> author.getId() == authorId).findFirst().orElseThrow();
    }

    public Author saveAuthor(Author body){
        Random rand = new Random();
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        authorList.add(body);
        return body;
    }

    public Author updateAuthor(int authorId, Author updatedAuthor){
        Author found = this.findAuthorById(authorId);
        found.setAvatar("https://ui-avatars.com/api/?name=" + updatedAuthor.getNome() + "+" + updatedAuthor.getCognome());
        found.setNome(updatedAuthor.getNome());
        found.setCognome(updatedAuthor.getCognome());
        found.setEmail(updatedAuthor.getEmail());
        found.setDataDiNascita(updatedAuthor.getDataDiNascita());
        return found;
    }

    public void deleteAuthor(int authorId){
        this.authorList.remove(this.findAuthorById(authorId));
    }
}
