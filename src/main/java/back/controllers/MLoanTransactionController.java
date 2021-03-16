package back.controllers;

import back.exception.ResourcesNotFoundException;
import back.models.MLoan;
import back.models.MLoanTransaction;
import back.repositories.MLoanTransactionRepository;
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
public class MLoanTransactionController {
    @Autowired
    MLoanTransactionRepository mLoanTransactionRepository;

    @GetMapping("/transaction")
    public List<MLoanTransaction> getAllMLoanTransaction() {
        return mLoanTransactionRepository.findAll();
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<MLoanTransaction> getMLoanTransactionById(@PathVariable(value = "id") Long mLoanTransactionId)
            throws ResourcesNotFoundException {
        MLoanTransaction mLoanTransaction = mLoanTransactionRepository.findById(mLoanTransactionId)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee not found for this id :: " + mLoanTransactionId));
        return ResponseEntity.ok().body(mLoanTransaction);
    }

    @PostMapping("/transaction")
    public MLoanTransaction createMLoanTransaction(@Valid @RequestBody MLoanTransaction mLoanTransaction) {
        return mLoanTransactionRepository.save(mLoanTransaction);
    }

    @PutMapping("/transaction/{id}")
    public ResponseEntity<MLoanTransaction> updateMLoanTransaction(@PathVariable(value = "id") Long mLoanTransactionId,
                                             @Valid @RequestBody MLoanTransaction mLoanTransactionDetails) throws ResourcesNotFoundException {
        MLoanTransaction mLoanTransaction = mLoanTransactionRepository.findById(mLoanTransactionId)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee not found for this id :: " + mLoanTransactionId));

        mLoanTransaction.setAmount(mLoanTransactionDetails.getAmount());
        mLoanTransaction.setIs_reversed(mLoanTransactionDetails.getIs_reversed());
        mLoanTransaction.setLoan_id(mLoanTransactionDetails.getLoan_id());
        mLoanTransaction.setTransaction_date(mLoanTransactionDetails.getTransaction_date());
        final MLoanTransaction updatedMLoanTarnsaction = mLoanTransactionRepository.save(mLoanTransaction);
        return ResponseEntity.ok(updatedMLoanTarnsaction);
    }

    @DeleteMapping("/transaction/{id}")
    public Map<String, Boolean> deleteMLoanTrasaction(@PathVariable(value = "id") Long mLoanTransactionId)
            throws ResourcesNotFoundException {
        MLoanTransaction mLoanTransaction = mLoanTransactionRepository.findById(mLoanTransactionId)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee not found for this id :: " + mLoanTransactionId));

        mLoanTransactionRepository.delete(mLoanTransaction);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
