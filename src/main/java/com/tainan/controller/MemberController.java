package com.tainan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tainan.exception.ResourceNotFoundException;
import com.tainan.myweb.Member;
import com.tainan.myweb.MemberRepository;

@RestController
@RequestMapping("/api/v1")
public class MemberController {
	
	@Autowired
    private MemberRepository memberRepository;
	
	@GetMapping("/employees")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
	
	@GetMapping("/employees/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable(value = "id") Long memberId)
        throws ResourceNotFoundException {
		Member member = memberRepository.findById(memberId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + memberId));
        return ResponseEntity.ok().body(member);
    }
	@PostMapping("/employees")
    public Member createMember(@Valid @RequestBody Member member) {
		System.out.println(member);
        return memberRepository.save(member);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable(value = "id") Long memberId,
         @Valid @RequestBody Member memberDetails) throws ResourceNotFoundException {
    	Member member = memberRepository.findById(memberId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + memberId));
    	
    	member.setName(memberDetails.getName());
    	member.setIdentitynum(memberDetails.getIdentitynum());
    	member.setEmail(memberDetails.getEmail());
    	member.setPassword(memberDetails.getPassword());
    	member.setAddres(memberDetails.getAddres());
    	member.setPhone(memberDetails.getPhone());
//    	member.setSex(memberDetails.getDementiaLevel());
//    	member.setHeight(memberDetails.getHeight());
//    	member.setWeight(memberDetails.getWeight());
//    	member.setAllergy(memberDetails.getAllergy());
//    	member.setBirthday(memberDetails.getBirthday());
//    	member.setChronicMedicalHistory(memberDetails.getChronicMedicalHistory());
//    	member.setCMSLevel(memberDetails.getCMSLevel());
//    	member.setContactname(memberDetails.getContactname());
//    	member.setContactPhone(memberDetails.getContactPhone());
//    	member.setDementiaLevel(memberDetails.getDementiaLevel());
//    	member.setEmail(memberDetails.getEmail());
//    	member.setFinancialSituation(memberDetails.getFinancialSituation());
//    	member.setMedicationProfile(memberDetails.getMedicationProfile());
//    	member.setNote(memberDetails.getNote());
//    	member.setPastMedicalHistory(memberDetails.getPastMedicalHistory());
//    	member.setSex(memberDetails.getSex());
//    	member.setPrimaryCaregiversPhone(memberDetails.getPrimaryCaregiversPhone());
//    	member.setPrimaryCaregiversName(memberDetails.getPrimaryCaregiversName());
    	
    	
    	
    	
        final Member updatedMember = memberRepository.save(member);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteMember(@PathVariable(value = "id") Long memberId)
         throws ResourceNotFoundException {
    	Member member = memberRepository.findById(memberId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + memberId));

    	memberRepository.delete(member);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
