package com.example.workshopmanagementapp.exceptions;

public class MechanicNotEmptyException extends Throwable{
    public MechanicNotEmptyException(String message){
        super.getMessage();} // -> wywołanie metody z klasy Throwable
}
