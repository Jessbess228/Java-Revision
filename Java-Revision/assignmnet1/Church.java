package ass1;

public class Church {
  
  public Church(){}
  
  public Church(Church from){}

  public boolean spec_equals(Church other){return false;}

  @Override
  public boolean equals(Object o){
    if (o instanceof Church)
      return spec_equals((Church)o);
    else
      return false;
  }

  public Church incr(){return null;}

  public Church decr(){return null;}

  public Church plus(Church other){return null;}

  public Church mult(Church other){return null;}

  public Church minus(Church other){return null;}
}
