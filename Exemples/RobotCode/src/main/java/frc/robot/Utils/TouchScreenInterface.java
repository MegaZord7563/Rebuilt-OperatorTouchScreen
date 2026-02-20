// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Utils;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class TouchScreenInterface {
    /**
     * add NT "selected Position NT Key"
     */
    public TouchScreenInterface() 
    {
        SmartDashboard.putString("SelectedPosition", "a");
    }

    /**
     * traslate selected position using an enum class
     */
    public enum PositionCommands {
        a(new InstantCommand(() -> System.out.println("a selected"))),
        b(new InstantCommand(() -> System.out.println("b selected"))),
        c(new InstantCommand(() -> System.out.println("c selected"))),
        d(new InstantCommand(() -> System.out.println("d selected"))),
        e(new InstantCommand(() -> System.out.println("e selected"))),
        f(new InstantCommand(() -> System.out.println("f selected"))),
        g(new InstantCommand(() -> System.out.println("g selected"))),
        h(new InstantCommand(() -> System.out.println("h selected"))),
        i(new InstantCommand(() -> System.out.println("i selected"))),
        j(new InstantCommand(() -> System.out.println("j selected"))),
        k(new InstantCommand(() -> System.out.println("k selected"))),
        l(new InstantCommand(() -> System.out.println("l selected"))),
        m(new InstantCommand(() -> System.out.println("m selected"))),
        n(new InstantCommand(() -> System.out.println("n selected"))),
        o(new InstantCommand(() -> System.out.println("o selected"))),
        p(new InstantCommand(() -> System.out.println("p selected")));

        Command command = null;

        PositionCommands(Command command) {
            this.command = command;
        }

        public Command getCommand() {
            if (command == null) {
                return new InstantCommand();
            }
            return command;
        }
    }

    PositionCommands selectedCommand = null;

    /**
     * Updates Selected Position Value based on NTs
     */
    public void updateInputs() {
        String buttonSelected = SmartDashboard.getString("SelectedPosition", "a");

        try 
        {
            selectedCommand = PositionCommands.valueOf(buttonSelected);
        } catch (IllegalArgumentException e) {
            DriverStation.reportWarning("Invalid interface command: " + buttonSelected, e.getStackTrace());
            System.out.println("please try again and select an interface position");
        }
    }

    public Command getInterfaceCommand()
    {
        return selectedCommand.getCommand();
    }
}
