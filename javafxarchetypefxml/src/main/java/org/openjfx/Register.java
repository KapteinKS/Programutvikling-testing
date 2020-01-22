package org.openjfx;

import java.util.ArrayList;

public class Register {
    ArrayList<Person> liste = new ArrayList();
    Avvik avvik = new Avvik();
    public String registrerPerson(String innNavn, String innAlder, String dd, String mm,
                                  String yyyy, String innEpost, String innTelefon) {

        if(!erBrukt(innNavn)) {
            try{
                int alder, dag, måned, år;
                alder = avvik.alder(Integer.parseInt(innAlder));
                dag = avvik.dag(Integer.parseInt(dd));
                måned = avvik.måned(Integer.parseInt(mm));
                år = avvik.år(Integer.parseInt(yyyy));
                avvik.antallDager(dag, måned, år);
                String navn = avvik.sjekkNavn(innNavn);
                String ePost = avvik.sjekkEpost(innEpost);
                String telefon = avvik.sjekkTelefon(innTelefon);

                liste.add(new Person(navn, alder, dag, måned, år, ePost, telefon));
            }
            catch (InvalidAgeException e){
                return e.getMessage();
            }
            catch (InvalidDateException e){
                return e.getMessage();
            } catch (InvalidNameException e) {
                return e.getMessage();
            } catch (InvalidEmailException e) {
                return e.getMessage();
            } catch (InvalidPhoneException e) {
                return e.getMessage();
            }
            return "";
        } else {
            return "Det finnes allerede en person med dette navnet i registeret";
        }
    }

    public boolean erBrukt(String navn){
        for(Person p : liste){
            if(p.getNavn().equalsIgnoreCase(navn)){
                return true;
            }
        }
        return false;
    }

    public String skrivUtListe(){
        String ut = "";
        for(Person p : liste){
            ut += p + "\n";
        }
        return ut;
    }
}

class Person {
    private String navn;
    private int alder;
    private Dato fDato;
    private String ePost;
    private String telefon;

    public Person(String navn, int alder, int dag, int måned, int år, String ePost, String telefon) {
        this.navn = navn;
        this.alder = alder;
        this.fDato = new Dato(dag, måned, år);
        this.ePost = ePost;
        this.telefon = telefon;
    }

    public String getNavn(){
        return navn;
    }

    @Override
    public String toString() {
        return "Navn; " + navn + ". Alder; " + alder + ". Fødselsdato; " + fDato +
                ". \n\tE-post; " + ePost + ". Tlf; " + telefon +".";
    }
}

class Dato{
    private int dag, måned, år;

    public Dato(int dag, int måned, int år) {
        this.dag = dag;
        this.måned = måned;
        this.år = år;
    }

    public String toString(){
        String ut = dag + "." + måned + "." + år;
        return ut;
    }
}