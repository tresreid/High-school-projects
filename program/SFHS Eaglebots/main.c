/* 
This is a simple demonstration of the BRAIN unit.
Each input channel is mapped to a servo and and 
speed control output
*/

#include <msp430x14x.h>
#include <bestapi.h>
//void outputLeft(unsigned int linke, unsigned int recht);
//void outputRight(unsigned int debugX, unsigned int debugY);

int main( void )
{
  unsigned int horizontal;
  unsigned int vertical;
  //unsigned int debugL;
  //unsigned int debugR;
  unsigned int IRemitter;
  unsigned int IRtoggle;
  signed int dump;
  //unsigned int toggledump;  <-- failed attempt
  //unsigned int dumpswitch;
  
  // short chan;
  // short inval;

  InitBrain();   /* initialize the system */
   
  // do this forever
  
  while(1)
  {
    // Drive Motors
    horizontal = getRcValue(0, 50, 50);
    vertical = getRcValue(1, 50, 50);
    
    setMotor(0, horizontal + vertical);
    setMotor(1, horizontal + vertical);
  
    // Dump mechanism, works in theory
    dump = getRcValue(2, 50, 200);
    
    setServo(0,dump);
    setServo(1,-dump + 2048);
    
    //setMotor(2,dump - 1074);
    //setMotor(3,-dump + 562);
      
    // Infrared trasmitter, also works in theory
    IRemitter = getRcValue(3, 50, 100);
    
    if(IRemitter == 512)
      IRtoggle = 500;
    
    if(IRemitter <= 35)
      IRtoggle = IRtoggle - 100;
    
    if(IRemitter >= 989)
      IRtoggle = IRtoggle + 100;
    
    if(100 <= IRtoggle <= 900)
      if(IRtoggle != 500)
        
        setServo(2, IRtoggle);

    //debugL = getRcValue(1, 50, 120);
    //debugR = getRcValue(2, 50, 120);
    //outputRight(debugL, debugR);
    
    
  }
}
