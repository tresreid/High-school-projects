/* wizardmain.c - this program works in combination with the 
web-based Brain Wizard (which produces wizardgen.h) to create
custom channel configurations for use with BEST competitions. 
2007 - BEST Robotics Inc
2008 version - allows simultaneous servo and speed control channels
*/
#include <msp430x14x.h>
//#include <signal.h>
#if defined(__GNUC__)
#include <io.h>
#endif
#include "wizardvars.h"
#include "wizardgen.h"
#include "wizardpost.h"
#define  DEADBAND      (8)

unsigned char chanfunc[4]={CHANNEL1_FUNC,CHANNEL2_FUNC,CHANNEL3_FUNC,CHANNEL4_FUNC};
unsigned short gain[4]={CHANNEL1_GAIN,CHANNEL2_GAIN,CHANNEL3_GAIN,CHANNEL4_GAIN};
short poslimit[4]={CHANNEL1_POSLIMIT,CHANNEL2_POSLIMIT,CHANNEL3_POSLIMIT,CHANNEL4_POSLIMIT};
short neglimit[4]={CHANNEL1_NEGLIMIT,CHANNEL2_NEGLIMIT,CHANNEL3_NEGLIMIT,CHANNEL4_NEGLIMIT};
short posthresh[4]={CHANNEL1_POSTHRESH,CHANNEL2_POSTHRESH,CHANNEL3_POSTHRESH,CHANNEL4_POSTHRESH};
short negthresh[4]={CHANNEL1_NEGTHRESH,CHANNEL2_NEGTHRESH,CHANNEL3_NEGTHRESH,CHANNEL4_NEGTHRESH};
unsigned char servoout[4]={CHANNEL1_SERVO,CHANNEL2_SERVO,CHANNEL3_SERVO,CHANNEL4_SERVO};
unsigned short chanmap[4]={0,1,2,3};  //standard mapping - not really needed at the moment

int main( void )
{
 short chan;
 short inval;
 short i;

  InitBrain(); // setup I/O, com, etc and enable interrupts
  
  // add fixed gain (this allows wizard gain limits match DSP gain limits)
  for (i=0;i<4;i++) gain[i]=gain[i]*115/100;  // 1.15 fixed gain
  
  // this is the wizard execution loop
  // do this forever
  while(1)
  {
    // iterate all the channels
    for(chan=0;chan!=4;chan++)
    {
      inval=getRcValue(chan,DEADBAND,gain[chan]);

      switch(chanfunc[chan])
      {
          case CHANFUNC_SPEEDCTL:
          // set the speed controller on this channel 
            if(((inval>RCIDLEVAL)&&(getSwitch(poslimit[chan])))||
               ((inval<RCIDLEVAL)&&(getSwitch(neglimit[chan]))))
            {
              // on speed controls we stop them on limits
              setMotor(chanmap[chan],RCIDLEVAL);
            }
            else
              setMotor(chanmap[chan],inval);

			if (servoout[chan]) setServo(chanmap[chan],inval); // servo output 

            break;
          case CHANFUNC_SERVOOUT:
            setServo(chanmap[chan],inval);
            break;
          case CHANFUNC_REVSW:
       	    if (servoout[chan]) setServo(chanmap[chan],inval); // servo output with revswitch
            if(((inval>RCIDLEVAL)&&(getSwitch(poslimit[chan])))||
               ((inval<RCIDLEVAL)&&(getSwitch(neglimit[chan]))))
            {
              // on reverse Sw we stop them on limits
              setMotor(chanmap[chan],RCIDLEVAL);
            }
            else
            {
              if(inval >(RCIDLEVAL+posthresh[chan]))
              {   
                setMotor(chanmap[chan],RCMAXVAL);   
                break;
              }
              if(inval <(RCIDLEVAL+negthresh[chan]))
              {
                 setMotor(chanmap[chan],RCMINVAL);
                 break;
              }

              setMotor(chanmap[chan],RCIDLEVAL);
            }


          break;
          case CHANFUNC_UNDEFINED:
          default:
            break;
      }
    }
  }
  volatile unsigned int i;            // volatile to prevent optimization

  //Let's get some excitement in here!
  //label "SELFDESTRUCTTIMER"
  q = 620000;                          // SW Delay
  do q--;
  while (q != 0);
    P1OUT ^= BIT7;                      // Toggle P1.7 using exclusive-OR
    P1 |= 80000;                     // SEIZURE TIME (atleast it should be)
  //If this works, it's a miracle... To be honest, I HAVE NO IDEA WHAT I'M DOING, maybe I should wait for an actual robot...
}

