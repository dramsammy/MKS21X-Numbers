public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);
    numerator = nume;
		denominator = deno;
  }

  public double getValue(){
    return 1.0 * numerator/denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){

    return new RationalNumber (denominator,numerator);
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return this.getValue() == other.getValue();
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (numerator == 0 || denominator == 0){
      return "0";
    }
    if (denominator == 1){
      return "" + numerator;
    }
    if ((numerator < 0 || denominator < 0) && !(numerator < 0 && denominator < 0)){
      return "-" + numerator + "/" + denominator;
    }
    return numerator + "/" + denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    if (a>b){
			int max = a;
		}
			int max = b;
		if (a<b){
			int min = a;
		}
			int min = b;
		if (max % min == 0){
			return max;
		}
		else if (min % (max % min) == 0){
			return min;
		}
		a = min;
		b = max % min;
		return gcd(a,b);
	}

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int reducevalue=gcd(numerator, denominator);
    		numerator/=reducevalue;
    		denominator/=reducevalue;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(this.getNumerator()*other.getNumerator(),this.getDenominator()*other.getDenominator());
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return this.multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
//  public RationalNumber add(RationalNumber other){
//    return new RationalNumber((this.getNumerator() * gcd(this.getDenominator(),other.getDenominator()) + other.getNumerator() * gcd(this.getDenominator(),other.getDenominator())),gcd((this.getDenominator(),other.getDenominator())));
//  }
  /**
  *Return a new RationalNumber that this minus the other
  */
//  public RationalNumber subtract(RationalNumber other){
  //  return this.add(other.multiply(new RationalNumber(-1,1)));
  //}
}
