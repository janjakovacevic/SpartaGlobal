public class WrapperClasses{

  public void autoBoxing(){
    int number = 5;

    // boxing
    // Integer integer = new Integer(number);

    // autoBoxing
    Integer integer = number;
  }

  public void autoUnboxing(){
    int number = 5;

    Integer integer = number;
    // unboxing
    // int value = integer.intValue();

    // autoUnboxing
    int value = integer;
  }

  public void numericPromotion(){
    // widening conversion
    int number1 = 3;
    long number2 = 5;
    long add = number1 + number2; //bigger data type

    float number3 = 10.0f;
    double number4 = 12.0;
    double decimalValue = number3 * number4;
  }

  public void typeCasting(){
    // narrowing conversion
    // widening conversion
    int number1 = 3;
    long number2 = 5;
    int add = (int) (number1 + number2); //smaller data type requires cast

    float number3 = 10.0f;
    double number4 = 12.0;
    float decimalValue = (float) (number3 * number4);
    int decimalValue = (int) (number3 * number4);
  }

}
