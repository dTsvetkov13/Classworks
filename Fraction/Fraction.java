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
}