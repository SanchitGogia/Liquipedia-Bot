package com.csbot.tlou;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

//import java.util.concurrent.TimeUnit;

public class DMevent extends ListenerAdapter {
    /*static long UID = 0L;
    static int flag = 0;*/
    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getMessage().getContentRaw().equals("!DM")){
            Member member = e.getMember();
            member.getUser().openPrivateChannel().queue(channel->{
                channel.sendMessage("Hello").queue();
            });
        }
    }
   /* private void spamfunc(MessageReceivedEvent e){
        Thread thread = new Thread (()->{
            while (flag == 1){
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                e.getChannel().sendMessage("Ping").queue();
                System.out.println("Works");
            }
        });
        thread.start();*/

    }

