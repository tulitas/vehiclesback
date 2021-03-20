package back.controllers;

import back.models.MLoan;
import back.repositories.MLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import back.exception.ResourcesNotFoundException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MLoanController {
    @Autowired MLoanRepository mLoanRepository;
    MLoan mLoan = new MLoan();
    @GetMapping("/mloan")
    public List<MLoan> getAllMLoan() {
        return mLoanRepository.findAll();
    }


    @GetMapping("/mloan/{id}")
    public ResponseEntity<MLoan> getMLoanById(@PathVariable(value = "id") Long mLoanId)
            throws ResourcesNotFoundException {
        MLoan mLoan = mLoanRepository.findById(mLoanId)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee not found for this id :: " + mLoanId));
        return ResponseEntity.ok().body(mLoan);
    }

    @PostMapping("/mloan")
    public MLoan createMLoan(@Valid @RequestBody MLoan mLoan, Model model) {

        int set = mLoanRepository.getLastId() + 1;
        mLoan.setAccount_no(String.valueOf(set));
          return mLoanRepository.save(mLoan);
    }

    @PutMapping("/mloan/{id}")
    public ResponseEntity<MLoan> updateMLoan(@PathVariable(value = "id") Long mLoanId,
                                                   @Valid @RequestBody MLoan mLoanDetails) throws ResourcesNotFoundException {
        MLoan mLoan = mLoanRepository.findById(mLoanId)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee not found for this id :: " + mLoanId));

        mLoan.setAccount_no(mLoanDetails.getAccount_no());
        mLoan.setDisbursedon_date(mLoanDetails.getDisbursedon_date());
        final MLoan updatedMLoan = mLoanRepository.save(mLoan);
        return ResponseEntity.ok(updatedMLoan);
    }

    @DeleteMapping("/mloan/{id}")
    public Map<String, Boolean> deleteMLoan(@PathVariable(value = "id") Long mLoanId)
            throws ResourcesNotFoundException {
        MLoan mLoan = mLoanRepository.findById(mLoanId)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee not found for this id :: " + mLoanId));

        mLoanRepository.delete(mLoan);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
