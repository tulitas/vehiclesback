package back.controllers;

import back.exception.ResourcesNotFoundException;
import back.models.MLoanRepaymentSchedule;
import back.repositories.MLoanRepaymentSheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MLoanRepaymentScheduleController {
    @Autowired
    MLoanRepaymentSheduleRepository mLoanRepaymentSheduleRepository;

    @GetMapping("/mloanrepayment")
    public List<MLoanRepaymentSchedule> getAllMLoanRepayment() {
        return mLoanRepaymentSheduleRepository.findAll();
    }

    @GetMapping("/mloanrepayment/{id}")
    public ResponseEntity<MLoanRepaymentSchedule> getMLoanRepaymentById(@PathVariable(value = "id") Long mLoanRepaymentId)
            throws ResourcesNotFoundException {
        MLoanRepaymentSchedule mLoanRepaymentSchedule = mLoanRepaymentSheduleRepository.findById(mLoanRepaymentId)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee not found for this id :: " + mLoanRepaymentId));
        return ResponseEntity.ok().body(mLoanRepaymentSchedule);
    }

    @PostMapping("/mloanrepayment")
    public @Valid MLoanRepaymentSchedule createMLoanRepayment(@Valid @RequestBody MLoanRepaymentSchedule mLoanRepaymentSchedule) {
        return mLoanRepaymentSheduleRepository.save(mLoanRepaymentSchedule);
    }

    @PutMapping("/mloanrepayment/{id}")
    public ResponseEntity<MLoanRepaymentSchedule> updateMLoanRepayment(@PathVariable(value = "id") Long mLoanRepaymentScheduleId,
                                             @Valid @RequestBody MLoanRepaymentSchedule mLoanRepaymentScheduleDetails) throws ResourcesNotFoundException {
        MLoanRepaymentSchedule mLoanRepaymentSchedule = mLoanRepaymentSheduleRepository.findById(mLoanRepaymentScheduleId)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee not found for this id :: " + mLoanRepaymentScheduleId));

        mLoanRepaymentSchedule.setCompleted_derived(mLoanRepaymentScheduleDetails.getCompleted_derived());
        mLoanRepaymentSchedule.setDuedate(mLoanRepaymentScheduleDetails.getDuedate());
        mLoanRepaymentSchedule.setFee_charges_amount(mLoanRepaymentScheduleDetails.getFee_charges_amount());
        mLoanRepaymentSchedule.setInterest_amount(mLoanRepaymentScheduleDetails.getInterest_amount());
        mLoanRepaymentSchedule.setPanalty_charges_amount(mLoanRepaymentScheduleDetails.getPanalty_charges_amount());
        mLoanRepaymentSchedule.setPrincipal_amount(mLoanRepaymentScheduleDetails.getPrincipal_amount());
        final MLoanRepaymentSchedule updatedMLoanRepayment = mLoanRepaymentSheduleRepository.save(mLoanRepaymentSchedule);
        return ResponseEntity.ok(updatedMLoanRepayment);
    }

    @DeleteMapping("/mloanrepayment/{id}")
    public Map<String, Boolean> deleteMLoanReapyment(@PathVariable(value = "id") Long mLoanRepaymentScheduleId)
            throws ResourcesNotFoundException {
        MLoanRepaymentSchedule mLoanRepaymentSchedule = mLoanRepaymentSheduleRepository.findById(mLoanRepaymentScheduleId)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee not found for this id :: " + mLoanRepaymentScheduleId));

        mLoanRepaymentSheduleRepository.delete(mLoanRepaymentSchedule);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
