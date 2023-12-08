package picasso.view.commands;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JOptionPane;

import picasso.model.Pixmap;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.util.Command;

/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 * @author Sara Sprenkle
 */
public class Evaluator implements Command<Pixmap> {
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;
	private JTextField input;
	
	public Evaluator(JTextField input) {
		this.input = input;
	}

	/**
	 * Evaluate an expression for each point in the image.
	 */
	public void execute(Pixmap target) {
		try {
		// create the expression to evaluate just once
		if (!input.getText().startsWith("//")) {
			ExpressionTreeNode expr = createExpression( (input.getText()).replaceAll("\"", "") );
			// evaluate it for each pixel
			Dimension size = target.getSize();
			for (int imageY = 0; imageY < size.height; imageY++) {
				double evalY = imageToDomainScale(imageY, size.height);
				for (int imageX = 0; imageX < size.width; imageX++) {
					double evalX = imageToDomainScale(imageX, size.width);
					Color pixelColor = expr.evaluate(evalX, evalY).toJavaColor();
					target.setColor(imageX, imageY, pixelColor);
				}
			}
		} 
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "The expression you entered is currently unsupported. Please enter a new expression.", "Parse Exception Error",0, null);
		}
	}

	/**
	 * Convert from image space to domain space.
	 */

	protected double imageToDomainScale(int value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return ((double) value / bounds) * range + DOMAIN_MIN;
	}

	/**
	 * 
	 * A place holder for a more interesting way to build the expression.
	 */
	ExpressionTreeNode createExpression(String function) {
		// Note, when you're testing, you can use the ExpressionTreeGenerator to
		// generate expression trees from strings, or you can create expression
		// objects directly (as in the commented statement below).

		//String test = "x + y";

		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		return expTreeGen.makeExpression(function);
		// return new Multiply( new X(), new Y() );
	}


}
