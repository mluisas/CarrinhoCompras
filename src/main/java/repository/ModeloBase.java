package repository;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public interface ModeloBase<IdType> extends ParameterizedType{

    default IdType getId(){
        // class that should represent IdType
        Class<?> comparisonClass;
        try{
            comparisonClass = Class.forName(this.getActualTypeArguments()[0].getTypeName());
        } catch(ClassNotFoundException e){
            throw new RuntimeException("Invalid class returned in getActualTypeArguments: " + e.getMessage());
        }
        for(Field field : this.getClass().getFields()){
            if(field.isAnnotationPresent(Id.class)){
                field.setAccessible(true);
                try{
                    Object idObject = field.get(this);
                    if(comparisonClass.isInstance(idObject)){
                        return (IdType)idObject;
                    }
                } catch(Exception e) {
                    throw new IllegalStateException("Id-annotated field couldn't be cast to IdType: " + e.getMessage());
                }
            }
        }
        ArrayList<Method> methods = new ArrayList<>(List.of(this.getClass().getMethods()));
        for(Class<?> c = this.getClass().getSuperclass(); c != null; c = c.getSuperclass()){
            methods.addAll(List.of(c.getMethods()));
        }
        for(Class<?> classInterface : this.getClass().getInterfaces()){
            for(Class<?> c = classInterface; c != null; c = c.getSuperclass()){
                methods.addAll(List.of(c.getMethods()));
            }
        }
        for(Method method : methods){
            if(method.isAnnotationPresent(Id.class)){
                method.setAccessible(true);

                Object returnObject;
                try{
                    returnObject = method.invoke(this);
                } catch(Exception e){
                    throw new RuntimeException(e);
                }
                if(comparisonClass.isInstance(returnObject)){
                    return (IdType)returnObject;
                } else if(returnObject instanceof ModeloBase){
                    Object returnOfReturn = ((ModeloBase)returnObject).getId();
                    if(comparisonClass.isInstance(returnOfReturn)){
                        return (IdType)returnOfReturn;
                    } else{
                        throw new IllegalStateException("Id-annotated method couldn't be cast to IdType nor ModeloBase");
                    }
                }
            }
        }
        return null;
    }

    // TODO: add method checking here too, to match getId behavior
    default void setId(IdType value){
        for(Field field : this.getClass().getFields()){
            if(field.isAnnotationPresent(Id.class)){
                field.setAccessible(true);
                try{
                    field.set(this, value);
                } catch(IllegalAccessException e){
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }

}
