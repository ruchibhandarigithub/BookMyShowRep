package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.converter.TicketConverter;
import com.example.BookMyShow.dto.entryDto.BookTicketRequestDto;
import com.example.BookMyShow.dto.responseDto.TicketResponseDto;
import com.example.BookMyShow.model.Show;
import com.example.BookMyShow.model.ShowSeats;
import com.example.BookMyShow.model.Ticket;
import com.example.BookMyShow.model.User;
import com.example.BookMyShow.repository.ShowRepository;
import com.example.BookMyShow.repository.TicketRepository;
import com.example.BookMyShow.repository.UserRepository;
import com.example.BookMyShow.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponseDto getTicket(int id) {

        Ticket ticketEntity = ticketRepository.findById(id).get();

        TicketResponseDto ticketResponseDto = TicketConverter.convertEntityToDto(ticketEntity);

        return ticketResponseDto;

    }

    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {


        User userEntity = userRepository.findById(bookTicketRequestDto.getUserId()).get();
        Show showEntity = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        log.info("Ticket half processed");

        Set<String> requestSeats = bookTicketRequestDto.getRequestedSeats();


        List<ShowSeats> showSeatsEntityList = showEntity.getSeats();

        // for(ShowSeatsEntity seat: showSeatsEntityList) System.out.print(seat+" ");


//        //Another way to iterate. Try to study about it.
//        List<ShowSeatsEntity> bookedSeats = showSeatsEntityList
//                .stream()
//                .filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&!seat.isBooked()&&
//                        requestSeats.contains(seat.getSeatNumber()))
//                .collect(Collectors.toList());



        List<ShowSeats> bookedSeats = new ArrayList<>();

        for(ShowSeats seat :showSeatsEntityList){

            if(!seat.isBooked()&&seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&requestSeats.contains(seat.getSeatNumber())){
                bookedSeats.add(seat);
            }
        }

        if(bookedSeats.size()!=requestSeats.size()){
            //Al the seats were not avaiable
            throw new Error("All Seats not available");
        }

        //Step 2

        Ticket ticketEntity = Ticket.builder().
                user(userEntity)
                .show(showEntity)
                .seats(bookedSeats).
                build();



        //Step 3 :

        double amount = 0;

        for(ShowSeats showSeatsEntity: bookedSeats){

            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookedAt(new Date());
            showSeatsEntity.setTicket(ticketEntity);

            amount = amount + showSeatsEntity.getRate();
        }

        ticketEntity.setBookedAt(new Date());
        ticketEntity.setAllottedSeats(convertListOfSeatsEntityToString(bookedSeats));
        ticketEntity.setAmount(amount);


        //Connect in thw Show and the user

        showEntity.getTickets().add(ticketEntity);


        //Add the ticket in the tickets list of the user Entity
        userEntity.getTicketEntities().add(ticketEntity);


        ticketEntity = ticketRepository.save(ticketEntity);

        return TicketConverter.convertEntityToDto(ticketEntity);


    }

    public String convertListOfSeatsEntityToString(List<ShowSeats> bookedSeats){

        String str = "";
        for(ShowSeats showSeatsEntity : bookedSeats){

            str = str + showSeatsEntity.getSeatNumber()+" ";
        }

        return str;

    }
}