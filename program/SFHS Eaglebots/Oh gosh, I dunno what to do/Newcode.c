// Default BRAIN configuration program
// proportional control for motors and servos
// each motor channel is mapped to an input channel
// each servo channel is also mapped to an input channel
// servos 5 & 6 are driven by input channels 3 & 4
// all 8 digital inputs are used with motors as limit switches
// digital 1 closure stops  motor 1 + stick (>IDLE) motion
// digital 2 closure stops  motor 1 - stick (<IDLE) motion
// etc.
#include <msp430x14x.h>
#if defined(__GNUC__)
#include <io.h>
#endif
#include <bestapi.h>

#define DEADBAND      (8)

void DumpConfig(unsigned short chan);

unsigned short gain[4]={125,125,125,125};

int main( void )
{
 short chan;
 short inval;
 
  InitBrain();

  // this is the wizard execution loop
  // do this forever

  while(1)
  {
    // iterate all the channels
    for(chan=0;chan!=4;chan++)
    {
      inval=getRcValue(chan,DEADBAND,gain[chan]);
      setServo(chan,inval);
// check the limit switches and set the speed to idle when switched
      if ((inval>RCIDLEVAL&&getSwitch(chan*2))||
          (inval<RCIDLEVAL&&getSwitch(chan*2+1)))
      {
        inval=RCIDLEVAL;
      }
      setMotor(chan,inval);
      if (chan>=2) setServo(chan+2,inval);        // duplicate servo ouput
    }
  }
  volatile unsigned int i;            // volatile to prevent optimization
  
  //Let's get some excitement in here!
  //label "SELFDESTRUCTTIMER"
  q = 620000;                          // SW Delay
  do q--;
  while (q != 0);
  {
    P1OUT ^= BIT7;                      // Toggle P1.7 using exclusive-OR
    P1 |= 80000;                     // SEIZURE TIME (atleast it should be)
    //If this works, it's a miracle... To be honest, I HAVE NO IDEA WHAT I'M DOING, maybe I should wait for an actual robot...
  }
}

