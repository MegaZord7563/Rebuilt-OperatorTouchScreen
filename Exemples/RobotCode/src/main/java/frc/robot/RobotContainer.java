
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Utils.TouchScreenInterface;

public class RobotContainer {
  public static final CommandXboxController driverController = new CommandXboxController(0);

  /* Operator TouchScreen Interface */
  public static final TouchScreenInterface operatorInterface = new TouchScreenInterface();

  public RobotContainer() 
  {
    configureBindings();
  }

  private void configureBindings() 
  {
    /**
     * gets Interface command when its called by driverController pressing "b" button
     */
    driverController.b().onTrue(operatorInterface.getInterfaceCommand());
  }

  public Command getAutonomousCommand() {return null;}
}
