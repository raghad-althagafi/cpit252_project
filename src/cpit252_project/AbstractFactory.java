/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

/**
 *
 * @author Dana2
 */
public abstract class AbstractFactory {
    abstract Fabric getFabric(String fabric);
    abstract Garment getGarment(String garment);
}
