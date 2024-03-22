package com.sprinpay.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprinpay.itpark.domain.Administrateurs;

@Repository
public interface AdministrateursRepository extends JpaRepository<Administrateurs, Long> {
    /*
     * JpaRepository : C'est une interface fournie par Spring Data JPA qui fournit
     * des méthodes pour effectuer des opérations CRUD (Create, Read, Update,
     * Delete) sur une entité dans une base de données.
     * Cette interface définit des méthodes telles que save(), findById(),
     * findAll(), deleteById(), etc.
     */

    /*
     * Administrateurs : C'est le type d'entité que votre repository gère. Dans ce
     * cas, il
     * s'agit probablement de la classe Administrateurs qui représente les
     * utilisateurs de
     * votre application. Vous pouvez remplacer User par le nom de votre propre
     * classe d'entité si nécessaire.
     * 
     * Long : C'est le type de la clé primaire de l'entité. Ici, il s'agit d'un
     * Long, ce qui est courant pour les clés primaires générées automatiquement par
     * la plupart des bases de données relationnelles. Si votre clé primaire est
     * d'un type différent, vous devez spécifier ce type ici.
     */

}
