package br.inatel.cdg.annotation.reading;
import br.inatel.cdg.annotation.reading.NumberToSum;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
//Nessa classe você deverá implementar a sua solução
//Adicionalmente você também deverá criar
//a anotação NumberToSum como parte da solução

public class AnnotationReader<T> {
    private Class c;
    private Annotation[] ant; // recebe as anotacoes contidas em uma classe Class
    private Method[] methods; // recebe os métodos contidos em uma classe Class
    private Field[] fields; // recebe os atributos contidos em uma classe Class
    private NumberToSum num; // serve para armazenar temporariamente uma Annotation do tipo NumberToSum 
    private int soma; // armazena a soma de todas as Annottions do tipo NumberToSum em uma classe Class
	public AnnotationReader(Class<?> clazz) {
	        this.c =clazz;
	        this.soma=0;	
	}
    public void readAnnotations(){
        this.methods=this.c.getDeclaredMethods(); // recebe os métodos de uma classe Class
        this.fields=this.c.getDeclaredFields(); // recebe os atributos de uma classe Class
    }
    // calcula a soma 	
    public int getTotalSum(){
        for(Method m : this.methods){ // para todos os métodos da classe
            if(m.getAnnotations().length>0){ // Caso existam anotações no método
                this.ant=m.getDeclaredAnnotations(); // le as anotations de todos métodos, incluindo private 
                for(Annotation a:this.ant){ // para todas Annotations a  do Method m
		    // Se for do tipo Anotacoes$NumberToSum	
                    if(a.annotationType().getName().equals(NumberToSum.class.getPackage().getName()+".NumberToSum")){
			// Armazene em num o Objeto Annotation da classe NumberToSum                        
			num = m.getAnnotation(NumberToSum.class);
               		//Imprimo o valor apenas para conferência 
                        System.out.println("Value Attribute of Annotation: "+ num.value());
                        this.soma=this.soma+num.value(); // incrementa na soma
                    }
                }
            }
            
        }
        for(Field f : this.fields){// para todos os atributos
            if(f.getAnnotations().length>0){ //Caso existam anotações no atributo
                this.ant=f.getDeclaredAnnotations(); // le as anotacoes de todos os atributos, incluindo private
                for(Annotation a:this.ant){ // para toda Annotation a do Field f
		    //se for do tipo Anotacoes$NumberToSum	
                    if(a.annotationType().getName().equals(NumberToSum.class.getPackage().getName()+".NumberToSum")){
			// Armazene em num o Objeto Annotation da classe NumberToSum                        
			num = f.getAnnotation(NumberToSum.class);
			//Imprimo o valor apenas para conferência
                        System.out.println("Value Attribute of Annotation: "+ num.value());
                        this.soma=this.soma+num.value(); //incrementa a soma
                    }
                }
            }
            
        }
        int ret=this.soma; //valor temporario para retorno
	this.soma=0;	//zera a soma
        return ret; // retorna a soma total
    }
}
