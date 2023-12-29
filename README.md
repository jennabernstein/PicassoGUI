# Picasso

An application that allows the user to create expressions that
evaluate to images.


## Running Picasso

To run Picasso, run `picasso.Main`

## Project Organization

`src` - the source code for the project

`conf` - the configuration files for the project

The `images` directory contains some sample images generated from Picasso.  Some of the expressions for these images can be found in the `expressions` directory.

## Code Base History

This code base originated as a project in a course at Duke University.  The professors realized that the code could be designed better and refactored.  This code base has some code leftover from the original version.

## Extensions

Generating Random Expressions

- To generate a random expression utilizing a combination of the functions and operators that have been implemented, simply click the "Random" button in the Graphical User Interface in the top button panel. Continue generating new and fun images by clicking this button as many times as you would like (some look more fun than others).

Generating Expressions from a String

- To generate an expression from a String, input any string input you would like in the textfield. Then, click the button labeled "Generate From String." The program will accept the input as a seed to generate an expression that will be evaluated into an image. The same input will always yield the same image. (Be creative with your string expressions by using varied cases or different symbols to have more fun!) (My favorite is: Hello Dr. Sprenkle! How are you??)

Expression History

- History keeps track of previously evaluated expressions in a dropdown from the "History" tab, and allows the user to select an expression from this dropdown to evaluate again. It does so by utilizing the history view command and pulling from the expression list that is saved as the evaluator runs. If a user selects a previous expression from the dropdown, it inputs the expression into the text box, allowing the user to make changes if desired, before properly evaluating the expression again based on its type (string or expression)

Zoom
- To zoom into the middle of the displayed image, press the "Zoom in" button after you evaluate an expression. To zoom back outwards, press the "Zoom out" button. The farthest you can zoom out is what is initially first displayed when the expression is evaluated. You cannot zoom on the starting image that is displayed when you first start the application.
