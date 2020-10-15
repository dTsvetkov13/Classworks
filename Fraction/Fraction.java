package oop.classes;

public class Fraction {

	private int numerator;
	private int denominator;
	
	Fraction()
	{
		this.numerator = 0;
		this.denominator = 1;
	}
	
	Fraction(int numerator, int denominator)
	{
		setNumerator(numerator);
		setDenominator(denominator);
	}
	
	Fraction(int numerator)
	{
		setNumerator(numerator);
		setDenominator(1);
	}
	
	void setNumerator(int numerator)
	{
		this.numerator = numerator;
	}
	
	void setDenominator(int denominator)
	{
		if(denominator == 0)
		{
			throw(new RuntimeException("The denominator cannot be 0!\n"));
		}
		this.denominator = denominator;
	}
	
	int getNumerator()
	{
		return numerator;
	}
	
	int getDenomirator()
	{
		return denominator;
	}
	
	public String toString()
	{
		return numerator + " / " + denominator;
	}
	
	Fraction add(Fraction f)
	{
		Fraction result = new Fraction();
		
		result.setNumerator(this.numerator * f.getDenomirator() + f.getNumerator() * this.denominator);
		result.setDenominator(this.denominator * f.getDenomirator());
		
		return result;
	}
	
	Fraction substract(Fraction f)
	{
		Fraction result = new Fraction();
		
		result.setNumerator(this.numerator * f.getDenomirator() - f.getNumerator() * this.denominator);
		result.setDenominator(this.denominator * f.getDenomirator());
		
		return result;
	}
	
	Fraction multiply(Fraction f)
	{
		Fraction result = new Fraction();
		
		result.setNumerator(this.numerator * f.getNumerator());
		result.setDenominator(this.denominator * f.getDenomirator());
		
		return result;
	}
	
	Fraction divide(Fraction f)
	{
		return this.multiply(new Fraction(f.getDenomirator(), f.getNumerator()));
	}
	
	void simplify()
	{
		int gcd = gcd(this.numerator, this.denominator);
	    this.numerator /= gcd;
	    this.denominator /= gcd;
	}
	
	private static int gcd(int a, int b) {
	    return b == 0 ? a : gcd(b, a % b);
	}
}