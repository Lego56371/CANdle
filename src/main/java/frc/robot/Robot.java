// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.CANdleControlFrame;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.LarsonAnimation;
import com.ctre.phoenix.led.FireAnimation;
import com.ctre.phoenix.led.StrobeAnimation;
import com.ctre.phoenix.led.TwinkleAnimation;
import com.ctre.phoenix.led.TwinkleOffAnimation;
import com.ctre.phoenix.led.Animation;
import com.ctre.phoenix.led.RgbFadeAnimation;
import com.ctre.phoenix.led.SingleFadeAnimation;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //create a rainbox anim.
  RainbowAnimation rainbowAnimation = new RainbowAnimation(1, 1, 0);
  CANdle candle1 = new CANdle(1);
  FireAnimation fireAnimation = new FireAnimation(2, .25, 1000, 10, .75);
  LarsonAnimation larsonAnimation = new LarsonAnimation(255, 255, 255);
  StrobeAnimation strobeAnimation = new StrobeAnimation(255, 255, 255, 2, kDefaultPeriod, 100);
  //TwinkleAnimation tAnimation = new TwinkleAnimation(255, 255, 255, 0, 50, 100, null);
 // TwinkleOffAnimation tOffAnimation = new TwinkleOffAnimation(255, 255, 255, 5, kDefaultPeriod, 100, 90);
  RgbFadeAnimation rgbFadeAnimation = new RgbFadeAnimation();
  RainbowAnimation rainbowAnimation2 = new RainbowAnimation(1, kDefaultPeriod, 100);
  SingleFadeAnimation singleFadeAnimation = new SingleFadeAnimation(255, 255, 255, 0, 100, 100, 40);
  SingleFadeAnimation singleFadeAnimation2 = new SingleFadeAnimation(25, 255, 150, 0, 100, 100,0);
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;
  
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  
  @Override
  public void robotInit() {
    candle1.animate(fireAnimation);

    
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
    //candle1.animate(rainbowAnimation);
  }

  @Override
  public void disabledPeriodic() {
    //candle1.animate(rainbowAnimation); 
  }

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    candle1.animate(fireAnimation);
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    //candle1.animate(rainbowAnimation);
  }

  @Override
  public void teleopInit() {
    //candle1.animate(tAnimation);
    candle1.animate(singleFadeAnimation);
    candle1.animate(singleFadeAnimation2);
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //candle1.animate(tAnimation);
  }

  @Override
  public void testInit() {
    candle1.animate(rainbowAnimation2);
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
    //candle1.animate(rainbowAnimation2);
    //candle1.animate(strobeAnimation);
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    //candle1.setLEDs(255, 255, 255);
  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {
    //candle1.animate(tOffAnimation);
  }

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
