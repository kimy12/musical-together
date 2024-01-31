package com.musicaltogether.mugether.show.service;

import com.musicaltogether.mugether.show.domain.Show;
import com.musicaltogether.mugether.show.repository.ShowInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ShowService {
    private final ShowInfoRepository showInfoRepository;

    @Transactional
    public void saveShowInfo(Show show){
        showInfoRepository.save(show);
    }
}
